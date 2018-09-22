package tictactoe;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RefereeAspect {
	
	@Pointcut(value="execution(* tictactoe.Referee.find*(..))")
	private void callWinMethods(){}
	
	@Before("callWinMethods()")
	public void beforeWinsAdvice(){
		System.out.println("Before advice:: [findHorizantalWin, findVerticalWin & findDiagonalWin] methods");
	}
	@After("call(* tictactoe.Referee.look*(..))")
	public void afterLookupWinningAdvice(){
		System.out.println("After advice::running lookupWinning method");
	}
	@AfterThrowing(value = "execution(* tictactoe.Referee.flipPlayer(..))")
    public void afterAnyMethod(JoinPoint jp) {
        System.out.println("@After throwing advice::"+jp.getSignature());
    } 
}
