import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Array nums1 = new Array(3);
        Array nums2 = new Array(3);
        nums1.insert(1);
        nums1.insert(2);
        nums1.insert(3);
        nums2.insert(2);
        nums2.insert(3);
        Array intersection = new Array(2);
        intersection = nums1.intersect(nums2);
        // intersection.printe();
        // nums1.reverse();
        nums1.insertAt(0, 0);
        nums1.printe();
    }
}
