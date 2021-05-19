package br.com.trgs.definition.chart;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface IPDFDraw
{

   void draw( Graphics2D g2d, Rectangle clipBounds );

}
