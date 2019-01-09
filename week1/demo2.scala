class HelloThread extends Thread {
  override def run() {
    println("Hello Scala!")
    println("Hello Scala! 2")
  }
}

def main() {
  val t = new HelloThread
	val s = new HelloThread

	t.start()
	s.start()
	t.join()
	s.join()
}

main()
