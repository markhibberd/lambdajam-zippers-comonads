package library

trait Functor[F[_]] {
  def map[A, B](f: A => B): F[A] => F[B]
}

object Functor {
  def apply[F[_]: Functor]: Functor[F] =
    implicitly[Functor[F]]
}
