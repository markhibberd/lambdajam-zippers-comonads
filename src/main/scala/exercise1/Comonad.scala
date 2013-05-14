package exercise1

import library._

trait SemiComonad[F[_]] extends Functor[F] {
  def cobind[A, B](f: F[A] => B): F[A] => F[B]
  def cojoin[A](a: F[A]): F[F[A]]

  def extend[A, B](f: F[A] => B): F[A] => F[B] = cobind(f)
  def duplicate[A](a: F[A]): F[F[A]] = cojoin(a)

  /*
  Exercise 1
  ----------
  Re-implement cobind[Exercise] in terms of other semi-comonad primitives.
  Specifically, do not use cobind/extend here.

  The key observation is that cobind can be derived from other primitives.
  Similarly, cojoin can also be derived from other primitives (Exercise 2).
  In other words, one or the other is a sufficient sole primitive (+Functor) to describe a semi-comonad.

  ~~~ Use of cojoin/duplicate is necessary
  ~~~ List all primitives of SemiComonad, except for cobind/extend
  */
  def cobindExercise[A, B](f: F[A] => B): F[A] => F[B] =
    ???

  /*
  Exercise 2
  ----------
  Re-implement cojoin[Exercise] in terms of other semi-comonad primitives.
  Specifically, do not use cojoin/duplicate here.

  The key observation is that cojoin can be derived from other primitives.
  Similarly, cobind can also be derived from other primitives (Exercise 1).
  In other words, one or the other is a sufficient sole primitive (+Functor) to describe a semi-comonad.

  ~~~ Use of cobind/extend is necessary
  */
  def cojoinExercise[A](fa: F[A]): F[F[A]] =
    ???
}

object SemiComonad {
  def apply[F[_]: SemiComonad] =
    implicitly[SemiComonad[F]]

  def OptionSemiComonad: SemiComonad[Option] =
    new SemiComonad[Option] {
      /*
      Exercise 2
      ----------
      The Option semi-comonad duplicates all non-empty (Some) elements.
      */
      def cojoin[A](fa: Option[A]) =
        ???

      def map[A, B](f: A => B) =
        _ map f

      def cobind[A, B](f: Option[A] => B) =
        cobindExercise(f)
    }

  def ListSemiComonad: SemiComonad[List] =
    new SemiComonad[List] {
      /*
      Exercise 4
      ----------
      The List semi-comonad returns all non-empty tails of the given list.
      */
      def cojoin[A](fa: List[A]) =
        ???

      def map[A, B](f: A => B) =
        _ map f

      def cobind[A, B](f: List[A] => B) =
        cobindExercise(f)
    }

  /*
  Exercise 5
  ----------
  This function is often called "cokleisli composition."
  It composes two functions in the usual sense, however, the input argument traverses a comonad environment (F).
  The usual sense of function composition has the type:
    (B => C) => (A => B) => (A => C)
  Cokleisli composition puts the comonad environment in every argument position:
    (F[B] => C) => (F[A] => B) => (F[A] => C)
  */
  def compose[F[_], A, B, C](f: F[B] => C, g: F[A] => B)(implicit F: Comonad[F]): F[A] => C =
    ???
}

object SemiComonadLaws {
  // 1. Associative: forall a f g. cobind(cobind(a)(g))(f) = cobind(a)(g(cobind(_)(f)))
  def associative[F[_], A, B, C, D](fa: F[A], f: F[A] => B, g: F[B] => C)(implicit F: SemiComonad[F], E: Equal[F[C]]): Boolean =
    E.equal(
      F.cobind(g)(F.cobind(f)(fa)),
      F.cobind((fb: F[A]) => g(F.cobind(f)(fb)))(fa)
    )
}

trait Comonad[F[_]] extends SemiComonad[F] {
  def copoint[A](p: F[A]): A

  def extract[A](p: F[A]) = copoint(p)
  def copure[A](p: F[A]): A = copoint(p)
}

object Comonad {
  def apply[F[_]: Comonad] =
    implicitly[Comonad[F]]
}

object ComonadLaws {
  // 2. Left Identity: forall a. cobind(a)(copoint) == a
  def leftIdentity[F[_], A](fa: F[A])(implicit F: Comonad[F], E: Equal[F[A]]): Boolean =
    E.equal(F.cobind(F.copoint[A])(fa), fa)

  // 3. Right Identity: forall a f. copoint(cobind(a)(f)) = f(a)
  def rightIdentity[F[_], A, B](fa: F[A], f: F[A] => B)(implicit F: Comonad[F], E: Equal[B]): Boolean =
    E.equal(F.copoint(F.cobind(f)(fa)), f(fa))
}
