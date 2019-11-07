package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBAssembleIfPrepareEnd;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public class JBAssembleIfPrepareEnd<ParentType extends IJBAppend> extends IJBAssembleIfPrepareEnd<ParentType> implements JBConstants {


    private final JB jb;
    private final boolean brotherReality;
    private final ParentType parent;
    private final String key;

    public JBAssembleIfPrepareEnd(JB jb, ParentType parent, String key, boolean brotherReality) {
        this.jb = jb;
        this.parent = parent;
        this.brotherReality = brotherReality;
        this.key = key;
    }

    @Override
    public JBAssembleIf<ParentType> elseif(boolean if_) {
        return new JBAssembleIf<ParentType>(jb, parent, key, brotherReality, if_);
    }

    @Override
    public JBAssembleIf<ParentType> elseif(Object if_) {
        return elseif(JBUtils.b(if_));
    }

    @Override
    public JBAssembleElse<ParentType> else_() {


        return new JBAssembleElse<ParentType>(jb, parent, key, brotherReality);
    }

    @Override
    public ParentType eif() {
        return parent;
    }

    @Override
    public void append(String key, Object value) {
        //do nothing
    }

    @Override
    public boolean reality() {
        return parent.reality() && !brotherReality;
    }
}
