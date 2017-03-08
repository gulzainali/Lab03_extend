/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gul Zain
 */
import java.util.Comparator;
import java.util.PriorityQueue;
public class TableComparator  implements Comparator<Table>
{
    @Override
    public int compare(Table x, Table y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.capacity < y.capacity)
        {
            return 1;
        }
        if (x.capacity > y.capacity)
        {
            return -1;
        }
        return 0;
    }
    
}
