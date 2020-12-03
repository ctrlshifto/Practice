package com.design.pattern.template;

/**
 * @author WhomHim
 * @description 函数式写法的模板方法模式
 * @date Create in 2020/12/3 15:16
 */
public class TemplateMethodPatternLambda {

    interface Criteria {
        void check() throws ApplicationDenied;
    }

    class LoanApplication {

        /**
         * 抽象方法
         */
        private final Criteria identity;

        /**
         * 抽象方法
         */
        private final Criteria creditHistory;

        /**
         * 抽象方法
         */
        private final Criteria incomeHistory;

        public LoanApplication(Criteria identity,
                               Criteria creditHistory,
                               Criteria incomeHistory) {
            this.identity = identity;
            this.creditHistory = creditHistory;
            this.incomeHistory = incomeHistory;
        }

        /**
         * 使用函数接口实现检查方法并没有排除继承的方式。我们可以显式地在这些类中使用
         * Lambda 表达式或者方法引用。
         * @throws ApplicationDenied ApplicationDenied
         */
        public void checkLoanApplication() throws ApplicationDenied {
            identity.check();
            creditHistory.check();
            incomeHistory.check();
            reportFindings();
        }

        private void reportFindings() {
        }
    }

    class PersonalLoanApplication extends LoanApplication {

        public PersonalLoanApplication(Criteria identity, Criteria creditHistory, Criteria incomeHistory) {
            super(identity, creditHistory, incomeHistory);
        }

        protected void checkIncomeHistory() {

        }

    }


    class EmployeeLoanApplication extends PersonalLoanApplication {

        public EmployeeLoanApplication(Criteria identity, Criteria creditHistory, Criteria incomeHistory) {
            super(identity, creditHistory, incomeHistory);
        }

        @Override
        protected void checkIncomeHistory() {

        }
    }


    class CompanyLoanApplication extends LoanApplication {
        public CompanyLoanApplication(Company company) {
            super(company::checkIdentity,
                    company::checkHistoricalDebt,
                    company::checkProfitAndLoss);
        }

    }


    class ApplicationDenied extends Exception {
    }


    class Company {

        public void checkIdentity() {
        }

        public void checkHistoricalDebt() {
        }

        public void checkProfitAndLoss() {

        }
    }
}