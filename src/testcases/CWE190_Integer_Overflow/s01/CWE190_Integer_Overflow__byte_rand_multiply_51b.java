/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_rand_multiply_51b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-51b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: rand Set data to result of rand()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: multiply
 *    GoodSink: Ensure there will not be an overflow before multiplying data by 2
 *    BadSink : If data is positive, multiply by 2, which can cause an overflow
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s01;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_rand_multiply_51b
{
    public void badSink(byte data ) throws Throwable
    {

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(byte data ) throws Throwable
    {

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* POTENTIAL FLAW: if (data*2) > Byte.MAX_VALUE, this will overflow */
            byte result = (byte)(data * 2);
            IO.writeLine("result: " + result);
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(byte data ) throws Throwable
    {

        if(data > 0) /* ensure we won't have an underflow */
        {
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data < (Byte.MAX_VALUE/2))
            {
                byte result = (byte)(data * 2);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too large to perform multiplication.");
            }
        }

    }
}
