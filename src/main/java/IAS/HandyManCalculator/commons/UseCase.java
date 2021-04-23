package IAS.HandyManCalculator.commons;

public interface UseCase<I, O> {
    OperationResult<O> execute(I input);
}
