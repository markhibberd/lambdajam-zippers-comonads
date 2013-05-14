package exercise3

import library._
import exercise1._

case class Store[A, B](set: A => B, get: A) {
  /*
  Exercise 31
  -----------
  Map a functor over a Store[A, _].
  */
  def map[C](f: B => C): Store[A, C] =
    ???

  /*
  Exercise 32
  -----------
  Duplicate a Store[A, _].
  */
  def cojoin: Store[A, Store[A, B]] =
    ???

  /*
  Exercise 33
  -----------
  Implement the identity operation for `cojoin`.
  */
  def copoint: B =
    ???

  /*
  Exercise 34
  -----------
  Implement a cross-product of Store.
  */
  def product[C, D](s: Store[C, D]): Store[(A, C), (B, D)] =
    ???
}

object Store {
  class Store_[X] {
    type l[b] = Store[X, b]
  }

  /*
  Exercise 35
  -----------
  Instantiate the comonad instance for Store[X, _]
  */
  implicit def StoreComonad[X]: Comonad[Store_[X]#l] =
    ???
}
