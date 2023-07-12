package messenger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MessengerDAO dao = new MessengerDAO();
		MessengerDTO tmp = null;
		String userId, userPw, nick;
		int menu, row;
		
		while(true) {
			if (tmp != null) {
				System.out.printf("회원 닉네임 : %s님\n", tmp.getNick());
			}
			if(tmp == null) {
				System.out.println("1. 로그인");
				System.out.println("9. 회원가입");
			}
			else {
				System.out.println("1. 로그아웃");
			}
			
			if(tmp != null) {
				System.out.println("2. 회원정보확인");
				System.out.println("3. 회원정보수정");
				System.out.println("4. 채팅 접속");
			}
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				if(tmp == null) {
					System.out.print("아이디 입력 : ");
					userId = sc.nextLine();
					
					System.out.print("패스워드 입력 : ");
					userPw = sc.nextLine();
					
					tmp = new MessengerDTO();
					
					tmp = dao.login(userId, userPw);
					
					if(tmp != null) {
						System.out.printf("%s님 로그인\n", tmp.getNick());
					}
					else {
						System.out.println("아이디 또는 패스워드가 잘못되었습니다");
					}
					
					break;
				}
				else {
					tmp = null;
					System.out.println("로그아웃되었습니다 ~ ");
					break;
				}
				
			case 2:
				if(tmp == null) {
					System.out.println("메뉴를 확인하시고 다시 입력해주세요  ~ ");
					break;
				}
				System.out.println("아이디 : " + tmp.getUserId());
				System.out.println("닉네임 : " + tmp.getNick());
				break;
			case 3:
				if(tmp == null) {
					System.out.println("메뉴를 확인하시고 다시 입력해주세요 ~ ");
					break;
				}
				System.out.print("패스워드 확인 : ");
				userPw = sc.nextLine();
				
				row = dao.isPw(userPw, tmp.getUserId());
				
				if(row != 0) {
					System.out.println("패스워드가 일치합니다 ~ ");
					do {
						System.out.println("1. 패스워드 변경");
						System.out.println("2. 닉네임 변경");
						System.out.print("메뉴 선택 >> ");
						menu = Integer.parseInt(sc.nextLine());
						
						switch(menu) {
						case 1:
							System.out.print("변경할 패스워드 입력 : ");
							userPw = sc.nextLine();
							
							row = dao.changePw(userPw, tmp.getUserId());
							
							System.out.println(row != 0 ? "변경 성공" : "변경 실패");
							break;
						case 2:
							System.out.print("변경할 닉네임 입력 : ");
							nick = sc.nextLine();
							
							row = dao.chageNick(nick, tmp.getUserId());
							
							System.out.println(row != 0 ? "변경 성공" : "변경 실패");
							break;
						default:
							System.out.println("메뉴를 확인시고 다시 입력해주세요 ~ ");
							break;
						}
					}while(menu == 0);
				}
				else {
					System.out.println("패스워드가 틀렸습니다 ! ");
				}
				break;
			case 4:
				Socket so;
				String host;
				int port = 7777;
				
				System.out.print("접속할 서버의 IP 입력 : ");
				host = sc.nextLine();
				
				try {
					so = new Socket(host, port);
					// 메세지를 보내거나 받는 요소가 동시에 수행되어야 한다
					
					Sender sender = new Sender(sc, so, tmp.getNick());
					Thread th1 = new Thread(sender);
					Reciever reciever = new Reciever(so);
					Thread th2 = new Thread(reciever);
					File f = new File("ServerData.dat");
					
					if(f.exists()) {
						try {
				            // 파일 경로와 이름
				            String filePath = "ServerData.dat";
				            
				            // 파일을 바이트 스트림으로 읽어들임
				            FileInputStream fis = new FileInputStream(filePath);
				            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				            
				            // BufferedReader로 문자열을 읽어들임
				            BufferedReader br = new BufferedReader(isr);
				            String line;
				            while ((line = br.readLine()) != null) {
				                System.out.println(line);
				            }
				            
				            br.close();
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
					}
					
					th1.start();
					th2.run();
					
				} catch(IOException e) {
					e.printStackTrace();
				} finally {
					System.out.println("1");
				}
				break;
			case 9:
				System.out.println("신규 상품을 생성합니다");
				tmp = useBean(sc);
				row = dao.insert(tmp);
				System.out.println(row != 0 ? "회원가입 성공" : "회원가입 실패");
				break;
			case 0:
				System.out.println("프로그램을 종료합니다 ~ ");
				
				sc.close();
				
				return;
			default:
				System.out.println("메뉴를 확인하시고 다시 입력해주세요 ~ ");
				break;
			}
			System.out.println();
		}	// end while
	}	// end main
	
	static MessengerDTO useBean(Scanner sc) {
		MessengerDTO dto = new MessengerDTO();

		System.out.print("아이디 : ");
		dto.setUserId(sc.nextLine());

		System.out.print("패스워드 : ");
		dto.setUserPw(sc.nextLine());

		System.out.print("닉네임 : ");
		dto.setNick(sc.nextLine());

		return dto;
	}
}
