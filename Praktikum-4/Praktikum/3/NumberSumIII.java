public class NumberSumIII {

    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length]; // array keluaran
        int index = 0;

        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan
        boolean[] processed = new boolean[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (processed[i]) {
                continue;
            }
            
            
            Number temp = numbers[i];
            processed[i] = true;
            
            int operation = 0;
            
            for (int j = i + 1; j < numbers.length; j++) {
                if (!processed[j] && 
                    ((temp instanceof Byte && numbers[j] instanceof Byte) ||
                    (temp instanceof Short && numbers[j] instanceof Short) ||
                    (temp instanceof Integer && numbers[j] instanceof Integer) ||
                    (temp instanceof Long && numbers[j] instanceof Long) ||
                    (temp instanceof Float && numbers[j] instanceof Float) ||
                    (temp instanceof Double && numbers[j] instanceof Double))) {
                    
                    if (operation == 0) { 
                        temp = add(temp, numbers[j]);
                    } else if (operation == 1) { 
                        temp = subtract(temp, numbers[j]);
                    } else {
                        temp = multiply(temp, numbers[j]);
                    }
                    
                    processed[j] = true;
                    
                    operation = (operation + 1) % 3;
                }
            }
            result[index++] = temp;
        }

        // mengisi array result yang tersisa dengan null
        while (index < numbers.length) {
            result[index++] = null;
        }
        
        return result;
    } 

    private static Number add(Number a, Number b) {
        if (a instanceof Byte) {
            return (byte)(a.byteValue() + b.byteValue());
        } else if (a instanceof Short) {
            return (short)(a.shortValue() + b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() + b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() + b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        }
        return null;
    }
    
    private static Number subtract(Number a, Number b) {
        if (a instanceof Byte) {
            return (byte)(a.byteValue() - b.byteValue());
        } else if (a instanceof Short) {
            return (short)(a.shortValue() - b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() - b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() - b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        }
        return null;
    }
    
    private static Number multiply(Number a, Number b) {
        if (a instanceof Byte) {
            return (byte)(a.byteValue() * b.byteValue());
        } else if (a instanceof Short) {
            return (short)(a.shortValue() * b.shortValue());
        } else if (a instanceof Integer) {
            return a.intValue() * b.intValue();
        } else if (a instanceof Long) {
            return a.longValue() * b.longValue();
        } else if (a instanceof Float) {
            return a.floatValue() * b.floatValue();
        } else if (a instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        }
        return null;
    }
}
