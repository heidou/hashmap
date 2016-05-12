package mengka.test;

/**
 * @author mengka
 * @description
 * @data 2016/05/08.
 */
public abstract class Ball {

    private Integer number;

    public abstract void play();

    public void execute(){
        System.out.println("1111");
        play();
        number = 100;
    }
}
