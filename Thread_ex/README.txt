Android에서 Thread를 사용하는 예제

why use thread?
안드로이드의 UI 작업은 별도의 스레드가 아닌 메인 스레드에서 한다.
따라서 메인 스레드에서 무거운 작업을 수행하는 경우 Ui처리가 늦어지는등의 문제가 발생한다.
이를 해결하기 위해 무한루프와 같은 작업들은 스레드에서 처리한다. 

스레드는 예제와 같이 Thread1에는 1초마다 1증가 Thread2에는 3초마다 1증가와 같은
싱글 스레드에서는 처리하기 어려운 작업도 수월하게 처리 가능하다.
서로 별개로 작업을 수행하기 때문!

하지만 예제에서는 스레드에서 UI작업을 잘 수행하고 있다.
왜 UI 작업을 Main Thread에서 해야하는가?
-> 예제에서는 Thread1은 Thread1_Text를, Thread2는 Thread2_Text를 수정하고 있다.
하지만 Thread1, Tharead2가 같은 TextView를 수정해야 한다면? 당연히 동기화 문제가 발생할 것이고
이러한 문제 때문에 UI작업은 Main Thread에서 처리하도록 하는게 바람직하다. 
스레드의 UI작업을 Main Thread가 처리하도록 하기 위해 Handler를 사용한다.

스레드를 컨트롤 하고싶다면?
Handler를 사용해보자.
스레드의 UI작업을 Main Thread가 처리하도록 하기 위해 Handler를 사용한다.
https://github.com/limjunho/Android/tree/master/Handler_thread_ex