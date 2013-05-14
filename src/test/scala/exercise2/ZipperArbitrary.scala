package exercise2

import org.scalacheck.Arbitrary, Arbitrary._

object ZipperArbitrary {
  implicit def ArbitraryZipper[A](implicit A: Arbitrary[A]): Arbitrary[Zipper[A]] =
    Arbitrary(arbitrary[(List[A], A, List[A])] map  {
      case (l, x, r) => Zipper(l, x, r)
    })
}
