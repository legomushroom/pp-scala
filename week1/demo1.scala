class HelloThread extends Thread {
  override def run() {
    println("Hello Scala!")
  }
}

val t = new HelloThread

t.start()
t.join()
