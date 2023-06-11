[![](https://jitpack.io/v/lmghee/forest-noti.svg)](https://jitpack.io/#lmghee/forest-noti)

## forest-noti
[Forest](https://github.com/EDU-Forest/FOREST) 프로젝트의 공통 기능을 모아둔 라이브러리
<br/>
<br/>

### FEATURES
1. `JWT Decoder` : JWT token의 유효성 및 만료 시간 확인
2. `Mattermost Log Sender` : 발생한 에러를 팀원들 모두 Mattermost를 통해 확인 가능
3. `Custom Exception` : 에러 코드의 추상화를 통한 예외처리 통일화
<br/>

### HOW TO
**Step 1**. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
<br/>

**Step 2.** Add the dependency
```java
	dependencies {
	        implementation 'com.github.lmghee:forest-noti:Tag'
	}
```
