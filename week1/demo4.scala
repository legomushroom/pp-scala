def main() {
    class Account(private var amount: Int = 0) {
      	def printAmount() {
          println(this.amount)
        }
        def transfer(target: Account, n: Int) = {
            this.synchronized {
                target.synchronized {
                    this.amount -= n
                    target.amount += n
                }
            }
        }
    }

    def startThread(a: Account, b: Account, n: Int): Thread = {
        val k = new Thread {
            override def run() {
                for (i <- 0 until n) {
                    a.transfer(b, 1)
                }
            }
        }

        k.start()
        return k
    }

    val a1 = new Account(500000)
    val a2 = new Account(700000)

    val t = startThread(a1, a2, 15000)
    val s = startThread(a2, a1, 12000)

    t.join()
  	s.join()
  
  	a1.printAmount()
  	a2.printAmount()
}

// DeadLock! Each Account class locks on itself so no class ever have the access to the target monitor

main()