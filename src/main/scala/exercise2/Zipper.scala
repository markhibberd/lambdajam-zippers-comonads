package exercise2

import library._, list._

/**
 *
 * A `Zipper` is a focussed position, with a list of values to the left and to the right.
 *
 * For example, taking the list [0,1,2,3,4,5,6], the moving focus to the third position, the zipper looks like:
 *
 *   Zipper(lefts = [2,1,0], focus = 3, rights = [4,5,6])
 *
 * Supposing then we move left on this zipper:
 *
 *   Zipper(lefts = [1,0], focus = 2, rights = [3,4,5,6])
 *
 * Then suppose we add 17 to the focus of this zipper:
 *
 *   Zipper(lefts = [1,0], focus = 19, rights = [3,4,5,6])
 */
case class Zipper[A](lefts: List[A], focus: A, rights: List[A]) {
  /**
   Exercise 6
   ----------
   Map the given function over a Zipper.
   */
  def map[B](f: A => B): Zipper[B] =
    ???

  /*
  Exercise 7
  ----------
  Return true if the zipper has an element to the right.
  */
  def hasRight: Boolean =
    ???

  /*
  Exercise 8
  ----------
  Return true if the zipper has an element to the left.
  */
  def hasLeft: Boolean =
    ???

  /*
  Exercise 9
  ----------
  Move the zipper one element to the right, or not if there is not a right element.
  */
  def right: Option[Zipper[A]] =
    ???

  /*
  Exercise 10
  -----------
  Move the zipper one element to the left, or not if there is not a left element.
  */
  def left: Option[Zipper[A]] =
    ???

  /*
  Exercise 11
  -----------
  Return the list from this zipper.

  ~~~ Remember to preserve correct ordering
  */
  def toList: List[A] =
    ???

  /*
  Exercise 12
  -----------
  Update the focus with the given function.
  */
  def withFocus(k: A => A): Zipper[A] =
    ???

  /*
  Exercise 13
  -----------
  Set the focus to the given value.
  */
  def :=(a: A): Zipper[A] =
    ???

  /*
  Exercise 14
  -----------
  Move the focus to the right until the focus meets the given predicate.
  */
  def findRight(p: A => Boolean): Option[Zipper[A]] =
    ???

  /*
  Exercise 15
  -----------
  Move the focus to the left until the focus meets the given predicate.
  */
  def findLeft(p: A => Boolean): Option[Zipper[A]] =
    ???

  /*
  Exercise 16
  -----------
  Insert the given value at the focus and push the old focus to the right.
  */
  def insertPushRight(a: A): Zipper[A] =
    ???

  /*
  Exercise 17
  -----------
  Insert the given value at the focus and push the old focus to the left.
  */
  def insertPushLeft(a: A): Zipper[A] =
    ???

  /*
  Exercise 18
  -----------
  Move the focus to the first element.

  Note: should be tail recursice. Use annotation to help.
  */
  //@annotation.tailrec
  final def start: Zipper[A] =
    ???

  /*
  Exercise 18
  -----------
  Move the focus to the last element.

  Note: should be tail recursice. Use annotation to help.
  */
  //@annotation.tailrec
  final def end: Zipper[A] =
    ???

  /*
  Exercise 19
  -----------
  Duplicate the zipper to a zipper of zippers that holds every possible zipper from this one.

  ~~~ Use unfoldr
  */
  def cojoin: Zipper[Zipper[A]] =
    ???

  /*
  Exercise 20
  -----------
  Zip the given zipper with this zipper on the components (lefts, focus, rights) of each.

  ~~~ Use zipApply
  */
  def apply[B](f: Zipper[A => B]): Zipper[B] =
    ???

  /*
  Exercise 21
  -----------
  Traverse this zipper, starting left-most through an applicative environment.

  ~~~ Use traverseList
  ~~~ Careful to preserve appropriate order
  */
  def traverse[F[_], B](f: A => F[B])(implicit F: Applicative[F]): F[Zipper[B]] =
    ???

  /*
  Exercise 22
  -----------
  Swap the focus with the element to the right. If there is no element to the right, leave unchanged.
  */
  def swapRight: Zipper[A] =
    ???

  /*
  Exercise 23
  -----------
  Swap the focus with the element to the left. If there is no element to the left, leave unchanged.
  */
  def swapLeft: Zipper[A] =
    ???

  /*
  Exercise 24
  -----------
  Delete the focus and pull the new focus from the right. If there is no element to the right, leave unchanged.
  */
  def deletePullRight: Zipper[A] =
    ???

  /*
  Exercise 25
  -----------
  Delete the focus and pull the new focus from the left. If there is no element to the left, leave unchanged.
  */
  def deletePullLeft: Zipper[A] =
    ???

  /*
  Exercise 26
  -----------
  Move the focus to the right the given number of times. If the number is negative, move left up to 0 instead.
  */
  def rightN(n: Int): Option[Zipper[A]] =
    ???

  /*
  Exercise 27
  -----------
  Move the focus to the left the given number of times. If the number is negative, move right up to 0 instead.
  */
  def leftN(n: Int): Option[Zipper[A]] =
    ???

  /*
  Exercise 28
  -----------
  Move the focus to the right the given number of times. If the number is negative, move left up to 0 instead.
  If the movement exceeds the boundary of the zipper, return the number of times were moved to the boundary (in Left).
  */
  def rightAtN(n: Int): Either[Int, Zipper[A]] =
    ???

  /*
  Exercise 29
  -----------
  Move the focus to the left the given number of times. If the number is negative, move right up to 0 instead.
  If the movement exceeds the boundary of the zipper, return the number of times were moved to the boundary (in Left).
  */
  def leftAtN(n: Int): Either[Int, Zipper[A]] =
    ???

  /*
  Exercise 30
  -----------
  Move the focus to the given absolute index in the zipper.
  Be careful not to traverse the zipper more than is required.

  ~~~ Use leftAtN to move left
  ~~~ Use rightN and leftN
  */
  def nth(i: Int): Option[Zipper[A]] =
    ???
}

object Zipper {
  def fromList[A](a: List[A]): Option[Zipper[A]] =
    a match {
      case Nil => None
      case h::t => Some(Zipper(Nil, h, t))
    }
}
