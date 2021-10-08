package com.ggg.mybatisplus.aopclass;

import com.ggg.mybatisplus.common.ResultMap;
import com.ggg.mybatisplus.dto.AopDto;
import com.ggg.mybatisplus.dto.UserDto;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.myenum.InfoEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class AopClass {

    @Pointcut("@annotation(com.ggg.mybatisplus.annotation.AopAnnotation)")
    private void pointMyCut() {
    }

    @Pointcut("@annotation(com.ggg.mybatisplus.annotation.ChangeAnnotation)")
    private void pointCutSelectUserByName() {
    }


    @Around(value = "pointCutSelectUserByName()")
    public ResultMap<List<User>> changeReturnParam(ProceedingJoinPoint joinPoint) {
        ResultMap<List<User>> map = new ResultMap<>();
        try {
            map = (ResultMap<List<User>>) joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("changeReturnParam 转换异常");
        }

        map.setAop(AopDto.builder().txt("价值是相互联系和相互依存的；同时接地和动态化。例如，谦虚的价值与勇气所平衡。同样，自由的价值只能通过团队合作精神才能真正实现。实际上，我们的价值观展示了它们如何团结在一起，将我们团结为一个群体，这是我们集团的王牌之一，具有适应性，敏捷性和灵活性。" +
                "我们的价值观和商业道德守则营造了一种有益于我们整个生态系统的积极文化。 “诚实的价值”为我们与利益相关者的所有关系奠定了坚实的基础，而“团队精神”的价值则激发了尊重和开放的文化。我们完全致力于零腐败，遵守适用法律，在包括在线在内的所有互动中以专业行为行事，合理使用知识产权以及保护个人数据。" +
                "团队成员" +
                "我们的团队成员将受益于包容和公平的安全环境，并提供平等的机会，自由和乐趣。我们提供了一个无骚扰的工作场所，在这里您可以举报任何违反道德操守的行为，而不必担心受到报复，同时增强对利益冲突情况的相应意识，以及懂得如何适当地进行管理，以及获得正确的信息，以避免与内幕交易有关的风险。" +
                "客户群" +
                "我们以勇敢的态度来赢得客户的业务，并保证公平竞争。我们对提供价值的坚定承诺和客户至上的态度培育了长期的合作关系。我们的客户受益于我们独特的协作风格，这种协作风格基于透明度和相互信任。" +
                "合作伙伴和供应商" +
                "我们合理的，可持续的采购程序与我们的《供应商行为准则》保持一致，从而使我们的合作伙伴和供应商受益。" +
                "股东们" +
                "道德规范是提高业务绩效，使我们的股东受益的业务当务之急。" +
                "社会和公共机构" +
                "我们的谦逊——这一价值观向我们每个人灌输对负责任的行为的需求，以最大程度地减少负面环境影响。我们运营所在的社会受益于我们作为积极未来建筑师的行为，利用我们的数字共融战略，向所有人开放数字机遇。" +
                "《商业道德守则》适用于集团中任何级别的所有团队成员。遵守道德意味着按照我们共同的价值观和道德原则做正确的事。我们的道德热线SpeakUp是一项承诺，旨在维护我们团队成员和利益相关者提出道德问题的自由，使他们能够将道德付诸实践").mage(InfoEnum.INFO_SUCCESS).build());
        return map;

    }

    @Order(0)
    @Around("pointMyCut()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("======================");

        Object[] args = joinPoint.getArgs();
        UserDto arg = (UserDto) args[0];
        System.out.println(arg.getEmail());
        Object target = joinPoint.getTarget();
        ResultMap<List<User>> obj = (ResultMap<List<User>>) joinPoint.proceed();
        obj.setMessage("这是我修改后的版本");

        obj.setCode(202);

        return obj;
    }
}
