package mengka.test;

/**
 * @author mengka
 * @description
 * @data 2016/05/08.
 */
public class BallServiceImpl implements BallService,PlayService {
    @Override
    public void play() {
        System.out.print("BallService play...");
        InnerBall innerBall = new InnerBall();
        innerBall.foo();
    }

    @Override
    public void excute() {

    }

    private class InnerBall{
        public void foo(){
            System.out.print("InnerBall play...");
        }
    }
}
