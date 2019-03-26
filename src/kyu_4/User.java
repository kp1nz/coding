package kyu_4;

/**
 * 编写一个名为User的类，用于计算用户通过类似于Codewars使用的排名系统进行的数量。
 * <p>
 * 商业规则：
 * 用户从-8级开始，可以一直前进到8。
 * 没有0（零）等级。-1之后的下一个等级是1。
 * 用户将完成活动。这些活动也有排名。
 * 每次用户完成排名活动时，基于活动的排名更新用户排名进度
 * 从完成的活动中获得的进度相对于用户当前等级与活动等级的比较
 * 用户的排名进度从零开始，每当进度达到100时，用户的排名升级到下一级别
 * 在上一级别中获得的任何剩余进度将应用于下一级别的进度（我们不会取得任何进展）。唯一的例外是如果没有其他等级可以继续前进（一旦达到等级8，就没有进展）。
 * 用户无法超越等级8。
 * 唯一可接受的等级值范围是-8，-7，-6，-5，-4，-3，-2，-1,1,2,3,4,5,6,7,8。任何其他值都应该引发错误。
 * 进度得分如下：
 * <p>
 * 完成与用户排名相同的活动将获得3分
 * 完成排名低于用户排名的活动将值1分
 * 任何已完成的排名低于用户排名2级或更高级别的活动将被忽略
 * 完成排名高于当前用户排名的活动将加速排名进展。排名之间的差异越大，进展就越多。式是10 * d * d其中d等于在活动和用户之间的排名的差异。
 * 逻辑示例：
 * 如果排名为-8的用户完成排名为-7的活动，则他们将获得10个进度
 * 如果排名为-8的用户完成排名为-6的活动，则他们将获得40个进度
 * 如果排名为-8的用户完成排名为-5的活动，则他们将获得90个进度
 * 如果排名为-8的用户完成了排名为-4的活动，则他们将获得160个进度，从而导致用户升级到排名-7并且已经获得60个进展到他们的下一个级别
 * 如果排名为-1的用户完成排名为1的活动，他们将获得10个进度（请记住，忽略零排名）
 * 代码用法示例：
 * User user = new User();
 * user.rank; // => -8
 * user.progress; // => 0
 * user.incProgress(-7);
 * user.progress; // => 10
 * user.incProgress(-5); // will add 90 progress
 * user.progress; // => 0 // progress is now zero
 * user.rank; // => -7 // rank was upgraded to -7
 * 注意：在Java中，某些方法可能会抛出一个IllegalArgumentException。
 * <p>
 * 注意：Codewars不再将此算法用于其自己的排名系统。它使用纯粹的基于数学的解决方案，无论一组排名活动的完成顺序如何，都能提供一致的结果。
 *
 * @author kp1nz
 * @create 2019-03-26 20:13
 */
public class User {
    int rank = -8;
    int progress;

    public void incProgress(int rank) {
        if (rank > 8 || rank < -8 || rank == 0)
            throw new IllegalArgumentException();
        if (this.rank == rank)
            this.progress += 3;
        if (this.rank - 1 == rank)
            this.progress += 1;
        if (this.rank - 2 >= rank)
            this.progress += 0;
        if (this.rank < rank) {
            int de = rank - this.rank;
            if (rank>0){
                de-=1;
            }
            this.progress = 10 * de * de;
        }
        while (this.progress >= 100 && rank < 8) {
            if (++this.rank == 0)
                this.rank++;
            this.progress -= 100;
        }
        if (this.rank == 8) {
            this.rank = 8;
            this.progress = 0;
        }
    }


}
