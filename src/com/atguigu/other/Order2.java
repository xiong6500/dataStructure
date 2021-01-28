public class Order2 {
    public static void main(String[] args) {
        Random random = new Random();
        List list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(random.nextInt(1000));
        }
        Collections.sort(list);//对集合中的元素进行排序
        for (Object o : list) {
            System.out.print(o+" ");
        }
        System.out.println("你好sdsd");
    }
}