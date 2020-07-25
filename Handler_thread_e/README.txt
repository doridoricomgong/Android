핸들러를 사용한 예제

안드로이드에서는 main thread에서 UI작업을 하기 때문에 main thread에서 무한loop를 돌리거나
부담스러운 작업을 하는 경우에는 UI처리가 늦어지고 사용자는 답답함을 느끼게 된다.
/* 
참고로 서브 스레드에서 UI작업을 하는 경우에는 동기화 문제에 부딪히게 된다. 
ex) 하나의 textView에 main thread와 sub thread가 동시에 setText를 하는 경우
*/

what is handler?
안드로이드에서 사용할 수 있는 스레드간의 통신 방법중 가장 일반적인 방법으로는 핸들러(Handler)를
통해 메시지(Message)를 전달하는 방법이다.

how use?
반드시 main thread에서 수신 메시지를 처리하기 위해 핸들러 객체를 생성한다.

방법 1. handler객체의 sendEmptyMessage메서드를 이용해 메시지 송신
delay가 필요하다면 sendEmptyMessageDeleyed메서드를 사용

방법 2. handler객체의 post메서드를 사용
delay가 필요하다면 postDelayed메서드를 사용
post를 통해 Runnable 객체를 전달하면 해당 핸들러가 연결된 스레드에서 실행된다.
-> 스레드의 반복이 필요하다면 handleMessage에서 자신을 재귀호출
ex) handle.port(this);
