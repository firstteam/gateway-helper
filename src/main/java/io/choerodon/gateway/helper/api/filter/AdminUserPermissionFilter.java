package io.choerodon.gateway.helper.api.filter;

import io.choerodon.gateway.helper.domain.RequestContext;
import io.choerodon.gateway.helper.domain.CheckState;
import org.springframework.stereotype.Component;

@Component
public class AdminUserPermissionFilter implements HelperFilter {

    @Override
    public int filterOrder() {
        return 70;
    }

    @Override
    public boolean shouldFilter(RequestContext context) {
        return context.getCustomUserDetails().getAdmin() != null
                && context.getCustomUserDetails().getAdmin();
    }

    @Override
    public boolean run(RequestContext context) {
        context.response.setStatus(CheckState.SUCCESS_ADMIN);
        context.response.setMessage("Admin user have access to the interface, username: "
                + context.getCustomUserDetails().getUsername());
        return false;
    }
}
