package ru.job4j.calculate;

/**
*
* Calculate.
*
* @version $Id$
* @author Vladimir Kovalenko (mailto:skyplane.ru@gmail.com)
* @since 0.1
*/



public class Calculate {


    /* Конструктор, вывод строки в консоль.
    *@param arguments - String[] args
    */
    public static void main(String[] args) {
	System.out.println("Hello World");
    }


    /**
    * Method echo.
    * @param name Your name.
    * @return Echo plus your name.
    */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }

}
