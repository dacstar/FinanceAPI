@Slf4j
@Service("jwtService")
public class JwtServiceImpl implements IJwtService{

	private static final String SALT =  "luvookSecret";
	
	@Override
	public <T> String create(String key, T data, String subject){


		String jwt = Jwts.builder()
						 .setHeaderParam("typ", "JWT")
						 .setHeaderParam("regDate", System.currentTimeMillis())
						 .setSubject(subject)
						 .claim(key, data)
						 .signWith(SignatureAlgorithm.HS256, this.generateKey())
						 .compact();
		return jwt;
	}	

	private byte[] generateKey(){
		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			if(log.isInfoEnabled()){
				e.printStackTrace();
			}else{
				log.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}
		
		return key;
	}
    
    @Override
	public boolean isUsable(String jwt) {
		try{
			Jws<claims> claims = Jwts.parser()
					  .setSigningKey(this.generateKey())
					  .parseClaimsJws(jwt);
			return true;
			
		}catch (Exception e) {
			throw new UnauthorizedException();
		}
    }
    
    @Override
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader("Authorization");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(SALT.getBytes("UTF-8"))
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
		@SuppressWarnings("unchecked")
		Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
		return value;
	}
}