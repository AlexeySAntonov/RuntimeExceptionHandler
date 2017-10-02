# **Runtime exception handler**
## Runtime exceptions handler example:
If a thread (not the main thread) throws an exception of type RuntimeException, then to avoid blocking the try-catch-finally blocks, you can define your own UncaughtExceptionHandler in order to handle every possible situation. 
As a plus, the main thread continues its work

![Иллюстрация к проекту](https://drive.google.com/uc?export=download&id=0B0YnaV77PE5TZkI3cmthWkxYazA) 
