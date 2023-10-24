package baseball;

import Validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    Validation validation = new Validation();
    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    BaseballGameService baseballGameService= new BaseballGameService();
    public boolean gameStart() {
        boolean run= true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber=generateRandomNumber.generateRandomNumber();
        while(run){
            System.out.print("숫자를 입력해주세요. : ");
            String input = Console.readLine();
            validation.userGameStartValidation(input);
            run= baseballGameService.baseballGameServiceStart(input,computerNumber);
        }
        return true;
    }

    public boolean restartOrEnd () {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartOrEnd = Console.readLine();
        validation.userGameRestartOrEndValidation(restartOrEnd);
        if(restartOrEnd.equals("1")){
            return true;
        }
        if(restartOrEnd.equals("2")){
            return false;
        }
        return false;
    }
}
