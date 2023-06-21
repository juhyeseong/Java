package makeTV;

// TV 의 객체를 상상하면서
// 클래스를 구성하세요

// 객체의 속성은 필드로 표현합니다
// 객체의 기능은 메서드로 표현합니다

// 필드는 보통 공개되지 않습니다 (private)
// 메서드는 보통 공개되어 있습니다 (public)

public class TV {

	// 속성 : 전원, 채널, 음량, TV이름...?
	private boolean power;
	private int channel = 2;
	private int volume;
	private int mute;
	private static final int MAX_CHANNEL = 20;
	private static final int MIN_CHANNEL = 2;
	private static final int MAX_VOLUME = 10;
	private static final int MIN_VOLUME = 0;
	
	
	// 기능 : 전원온오프, 채널올림/내림, 음량올림/내림, 음소거
	public boolean onoff() {
		this.power = !power;
		show();
		return power;
	}
	
	// boolean타입의 getter는 is 혹은 has 혹은 can을 사용한다
	public boolean isPower() {
		return power;
	}
	
	public int channelUp() {
		if(power) {		// 전원이 켜져 있다면
			channel++;	// 채널의 값을 1증가시킨다
			if(channel > MAX_CHANNEL) {	// 만약, 채널의 값이 최대채널을 초과하면
				channel = MIN_CHANNEL;	// 최소 채널로 값을 새로 대입한다
			}
		}
		show();
		return channel;
	}
	
	public int channelDown() {
		if(power) {
			channel--;
			if(channel < MIN_CHANNEL) {
				channel = MAX_CHANNEL;
			}
		}
		show();
		return channel;
	}
	
	public int volumeUp() {
		if(power) {
			volume++;
			if(volume > MAX_VOLUME) {
				volume = MAX_VOLUME;
			}
		}
		show();
		return volume;
	}
	
	public int volumeDown() {
		if(power) {
			volume--;
			if(volume < MIN_VOLUME) {
				volume = MIN_VOLUME;
			}
		}
		show();
		return volume;
	}
	
	public boolean mute() {
		int tmp = volume;
		volume = mute;
		mute = tmp;
		show();
		return mute != 0;
	}
	
	public void show() {
		if(power) {
			System.out.printf("┌────────────┐\n");
			System.out.printf("│  CH : %2d   │\n", channel);
			System.out.printf("│  VL : %2d   │\n", volume);
			System.out.printf("└────────────┘\n");
		}
		else {
			System.out.printf("┌────────────┐\n");
			System.out.printf("│            │\n");
			System.out.printf("│            │\n");
			System.out.printf("└────────────┘\n");
		}
	}
	
	
	// 채널은 범위안에서 값이 순환할 수 있고, 음량은 최소/최대를 벗어날 수 없다
	
}









