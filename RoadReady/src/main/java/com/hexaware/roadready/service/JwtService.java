package com.hexaware.roadready.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    public static final String SECRET ="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	
    public String generateToken(String username) {
    	Map<String , Object> claims = new HashMap<>();
    	return createToken(claims, username);
    }
    
    public String createToken(Map<String , Object> claims , String username) { //claims is of map type has claim type and claim value 
		//add jwt dependencies (3)
		return Jwts.builder().setClaims(claims)
				             .setSubject(username)
				             .setIssuedAt(new Date(System.currentTimeMillis()))
				             .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))  //60 mins
	                         .signWith(getSignKey(), SignatureAlgorithm.HS256)           //many algos we can take one this one most used
	                         .compact();
	}
	
	private Key getSignKey() {
		byte[] keyBytes =Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(getSignKey())
				   .build()
				   .parseClaimsJws(token)
				   .getBody();
	}
	public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	public String extractUsername(String token) {
		return extractClaim(token , Claims::getSubject);
	}
	public Date extractExpiration(String token) {
		return extractClaim(token , Claims::getExpiration);
	}
	
	private boolean isTokenExpired(String token ) {
		return extractExpiration(token).before(new Date());
	}
	public boolean validateToken(String token , UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
