package library

object list {
  def unfoldr[A, B](f: B => Option[(A, B)], b: B): List[A] =
    f(b) match {
      case None => Nil
      case Some((a, bb)) => a :: unfoldr(f, bb)
    }

  def zipWith[A, B, C](f: (A, B) => C)(a: List[A], b: List[B]): List[C] =
    a match {
      case Nil => Nil
      case ha::ta => b match {
        case Nil => Nil
        case hb::tb => f(ha, hb) :: zipWith(f)(ta, tb)
      }
    }

  def zipApply[A, B](f: List[A => B], a: List[A]): List[B] =
    zipWith((j: A => B, k: A) => j(k))(f, a)

  def traverseList[F[_], A, B](f: A => F[B], x: List[A])(implicit F: Applicative[F]): F[List[B]] =
    x.foldRight[F[List[B]]](F.unit(Nil))((a, b) => F.apply(F.map((bb: B) => bb :: (_: List[B]))(f(a)))(b))

}
