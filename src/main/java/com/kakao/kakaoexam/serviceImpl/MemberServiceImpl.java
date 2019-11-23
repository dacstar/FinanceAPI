@Service
public class MemberServiceImpl implements IMemberService{


    @Autowired
	private MemberRespository memberRespository;

    public void signup(String id,String password){

        memberRespository.save(MemberEntity().builder()
        .id(id)
        .password(password)
        .build());



    }


    public String signin(String id,String password){

        try {
            MemberRespository member=memberRespository.findByid(id);
            if(member.getId() == id){
            String token = jwtService.create("member", member.getId(), "user");
            return token;
            }else{
                System.out.println("fail");
            }
        } catch(Exception e) {
            return "failed";
        }

    }

}