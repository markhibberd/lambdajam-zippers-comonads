package library

trait Apply[F[_]] extends Functor[F] {
  def apply[A, B](f: F[A => B]): F[A] => F[B]
}

object Apply {
  def apply[F[_]: Apply]: Apply[F] =
    implicitly[Apply[F]]
}
