import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ggg.mybatisplus.entity.Test1;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.util.JwtTool;
import com.ggg.mybatisplus.util.JwtUtil;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyTest {

    @Test
    public void test1() {

//        System.out.println(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(LocalDateTime.now()));
        System.out.println(LocalDateTime.now());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
//        String format1 = format.format(date);
//        System.out.println(format1);
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("==================");
        System.out.println(calendar.getTimeZone());
    }

    @Test
    public void test2() {
        String jwt = JwtUtil.generateToken("ggg");
        System.out.println("=========" + jwt + "==============");
        System.out.println(JwtUtil.validateToken(jwt));
    }

    @Test
    public void test3() {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(format.format(time));

        System.out.println("==============================");
        Date date = DateUtils.addDays(new Date(), 10);

        System.out.println(format.format(date));
        System.out.println("==============================");
        List<Test1> users = new ArrayList<>();
//        users.add(new Test1());
//        users.add(new Test1());
//        users.add(new Test1());
//        users.add(new Test1());
        List<Test1> test1s = new ArrayList<>();
        test1s.add(new Test1("name1", "name@ggg.com"));

        for (Test1 l : test1s) users.add(l);

        test1s.forEach(users::add);
////        test1s.forEach(System.out::println);
        System.out.println(users);
        System.out.println("==================");
        HashMap<String, String> map = new HashMap<>();
        map.put("22", "37");
        map.put("221", "36");
        map.put("2222", "35");
        map.put("22121", "34");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key=" + key + ";Value=" + value);
        }

        System.out.println("=================");

        users.add(new Test1("aa", "vbb"));
        Stream<Object> stream1 = users.stream().filter((e) -> {
            return e.getName().equals("aa");
        }).map((w) -> {
            return (Object) w;
        });
        System.out.println("======================");


        System.out.println("==================");
        users.forEach(System.out::println);
    }

    @Test
    public void test4() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("22", "22");
        String token = JwtTool.createToken(map);
        System.out.println(token);
    }

    @Test
    public void test5() {
//        String str = "";
//        boolean numeric = StringUtils.isNumeric(str);
//        Optional.ofNullable(str).filter((e) -> StringUtils.isNumeric(e)).orElseThrow(() -> new RuntimeException("不是数字"));
//        System.out.println(numeric);
//
//        UserServiceImpl userService = new UserServiceImpl();
//

        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();

        System.out.println(s.replace("-","").toUpperCase());
    }

    @Test
    public  void testPull(){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime max = LocalDateTime.MAX;

        System.out.println(LocalDateTime.now().plusHours(2));
        System.out.println("这是测试，NOTICE！！！"+max);
        System.out.println(new Date(Long.MAX_VALUE));
        LocalDateTime of = LocalDateTime.of(9999, 12, 30, 12, 59, 59);
        System.out.println(of);
        System.out.println(LocalDateTime.MAX.plusYears(Integer.MIN_VALUE));
    }

    @Test
    public void test9(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User().setId(1L));
        users.add(new User().setId(2L));
        users.add(new User().setId(3L));
        users.add(new User().setId(1L).setAge(2));
        int i=0;
        for(User user:users){

            if(user.getId()==1L){
                //users.remove(0);
                i++;
               continue;
            }
        }
        System.out.println(i);
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(users));
        users.forEach(System.out::println);
    }

    @Test
    public void test10(){
        List<String> list1=new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("g");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");

        for(String str:arrayList){
            list1.removeIf(value->value.equals(str));
        }
        list1.forEach(System.out::println);

//        for (int i = 0; i < 100000; i++) {
//            list1.add("gg");
//        }
//        long start = System.currentTimeMillis();
//        List<String> collect = list1.stream().distinct().collect(Collectors.toList());
//        long end = System.currentTimeMillis();
//        collect.forEach(System.out::println);
//        System.out.println("时间为"+(end-start));
//         list1 = ListUtils.removeAll(list1, arrayList);
//        list1.forEach(System.out::println);
    }
}
