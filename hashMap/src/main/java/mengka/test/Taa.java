package mengka.test;

/**
 * @author mengka
 * @description
 * @data 2016/05/08.
 */
public class Taa {

    public static void main(String[] args){
        Ball ball = new BasketBall();
        ball.execute();

        BallService ballService = new BallServiceImpl();
        ballService.play();
    }
}
