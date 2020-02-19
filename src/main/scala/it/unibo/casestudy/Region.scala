package it.unibo.casestudy

import it.unibo.scafi.space.{Point2D, Point3D}

trait Region {
  def withinRegion(p: Point2D): Boolean
}

case class RectangularRegion(start: Point2D, end: Point2D) extends Region {
  override def withinRegion(p: Point2D): Boolean = {
    p.x >= start.x && p.x <= end.x && p.y >= start.y && p.y <= end.y
  }
}

case class CircularRegion(center: Point2D, radius: Double) extends Region {
  override def withinRegion(p: Point2D): Boolean = {
    Math.sqrt(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2)) <= radius
  }
}