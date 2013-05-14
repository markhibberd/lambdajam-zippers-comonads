package library

trait Applicative[F[_]] extends Apply[F] {
  def unit[A](a: A): F[A]

  override def map[A, B](f: A => B) =
    apply(unit(f))
}

object Applicative {
  def apply[F[_]: Applicative]: Applicative[F] =
    implicitly[Applicative[F]]
}
