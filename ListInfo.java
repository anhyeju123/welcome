package Join;

import java.util.*;

public class ListInfo {
	Scanner sc = new Scanner(System.in);
		
		public void Join() {
			ArrayList<Info> jlist = new ArrayList<Info>();
			
			System.out.println("1.처음이에요 2.다시왔어요 3.확인해볼게요 4.다음에올게요");
			int num = sc.nextInt();
			
			if(num == 1) {
		
	        System.out.println("정보를 입력하세요");
	        
	        Info IF = new Info();
	        
	        System.out.print("이름 : ");
	        IF.setName(sc.next());
	        
	        System.out.print("강아지성별(M/F) : ");
	        IF.setGender(sc.next().charAt(0));
	        
	        System.out.print("견종 : ");
	        IF.setBreed(sc.next());
	        
	        IF.getAge();
	        
	        //몸무게 여기서 소중대 나누기엔 너무 다양함    
	        System.out.println("몸무게 : ");
	        IF.setKg(sc.next());
	        
	        System.out.println("알러지여부(YES/NO) : ");
	        IF.setAllergy(sc.next());
	        
	        System.out.println("중성화여부(YES/NO) : ");
	        IF.setNeuter(sc.next().charAt(0));
	        
	        jlist.add(IF);
	        
	        System.out.println("입력하신 정보가 " + jlist + " 맞나요?");
	        System.out.println("1.OK 2.NO");
	        int ok = sc.nextInt();    
		
	        while(ok == 1) {
	        	System.out.println("정보가 저장되었습니다.");
	        	
	        	break;
			}
			
			}else if(num == 2 && num == 3) {
				System.out.println("이름 : ");
			    String n = sc.next();
				System.out.println("나이 : ");
				int g = sc.nextInt();
				if(jlist.contains(new nm(n))) {
					int index = jlist.indexOf(n);
					n nm = (n)jlist.get(index);
				}
			}
	        
	       
	        
	        
		}   
	        
	        
	    
		   
		}
	
		


		   
	    
	

}
