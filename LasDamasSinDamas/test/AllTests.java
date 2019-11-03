/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    lasdamassindamas.controllers.MoveControllerTest.class,
    lasdamassindamas.models.BoardTest.class,
    lasdamassindamas.models.CoordinateTest.class,
    lasdamassindamas.models.GameTest.class,
    lasdamassindamas.models.PieceTest.class,
    lasdamassindamas.models.SquareTest.class,
    lasdamassindamas.models.TurnTest.class,
    lasdamassindamas.views.CommandViewTest.class
})

public class AllTests {
}
