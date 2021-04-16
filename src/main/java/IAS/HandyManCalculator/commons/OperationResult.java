package IAS.HandyManCalculator.commons;

public class OperationResult<V> {
    public static <VALUE> OperationResult<VALUE> ofValue(VALUE value) {
        return new OperationResult<>(null, value);
    }

    public static <VALUE> OperationResult<VALUE> ofError(IAS.HandyManCalculator.commons.OperationError error) {
        return new OperationResult<>(error, null);
    }

    private final IAS.HandyManCalculator.commons.OperationError error;
    private final V value;

    private OperationResult(IAS.HandyManCalculator.commons.OperationError error, V value) {
        this.error = error;
        this.value = value;
    }

    public boolean isError() {
        return this.error != null;
    }

    public boolean isSuccess() {
        return this.value != null;
    }

    public IAS.HandyManCalculator.commons.OperationError getError() {
        return error;
    }

    public V getValue() {
        return value;
    }
}
