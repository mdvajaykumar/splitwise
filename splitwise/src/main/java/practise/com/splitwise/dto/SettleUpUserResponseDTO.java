package practise.com.splitwise.dto;

import lombok.Getter;
import lombok.Setter;
import practise.com.splitwise.model.Expense;

import java.util.List;


@Getter
@Setter
public class SettleUpUserResponseDTO {
 private List<Expense> expenses;
}
