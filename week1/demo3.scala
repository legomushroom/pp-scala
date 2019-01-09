def main() {
  val x = new AnyRef {}
  var uidCount = 0L

	def getUniqueId(): Long = x.synchronized {
    uidCount = uidCount + 1
    uidCount
	}

	def startThread () = {
    val t = new Thread {
        override def run() {
            val uids = for (i <- 0 until 10) yield getUniqueId()
            println(uids)
        }
    }

    t.start()
    t
	}

	startThread()
  startThread()
}

main()