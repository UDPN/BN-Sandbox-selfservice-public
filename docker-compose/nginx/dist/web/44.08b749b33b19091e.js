"use strict";(self.webpackChunkudpn_b=self.webpackChunkudpn_b||[]).push([[44],{7044:(b,r,s)=>{s.r(r),s.d(r,{TestDataModule:()=>x});var d=s(9808),p=s(88),u=s(3075),c=s(4521),Z=s(8746),t=s(5e3),m=s(4004),T=s(520);let h=(()=>{class e{constructor(n){this.http=n}list(n){return this.http.post("v1/udpn/processing/common/manage/tn/test/data/select",{}).pipe((0,m.U)(z=>z))}}return e.\u0275fac=function(n){return new(n||e)(t.LFG(T.eN))},e.\u0275prov=t.Yz7({token:e,factory:e.\u0275fac,providedIn:"root"}),e})();var l=s(1758),f=s(7484),o=s(939);function v(e,a){if(1&e&&(t.TgZ(0,"tr"),t.TgZ(1,"td"),t._uU(2),t.qZA(),t.TgZ(3,"td"),t._uU(4),t.qZA(),t.TgZ(5,"td"),t._uU(6),t.qZA(),t.TgZ(7,"td"),t._uU(8),t.qZA(),t.TgZ(9,"td"),t._uU(10),t.qZA(),t.TgZ(11,"td"),t._uU(12),t.qZA(),t.qZA()),2&e){const n=a.$implicit;t.xp6(2),t.Oqu(n.privateKey),t.xp6(2),t.Oqu(n.accountAddress),t.xp6(2),t.Oqu(n.Balance),t.xp6(2),t.Oqu(n.Purpose),t.xp6(2),t.Oqu(n.url),t.xp6(2),t.Oqu(n.comments)}}function A(e,a){if(1&e&&(t.TgZ(0,"div"),t.TgZ(1,"nz-card",7),t.TgZ(2,"nz-table",8),t.TgZ(3,"thead"),t.TgZ(4,"tr"),t.TgZ(5,"th"),t._uU(6,"Private Key"),t.qZA(),t.TgZ(7,"th"),t._uU(8,"Account Address"),t.qZA(),t.TgZ(9,"th"),t._uU(10,"Balance"),t.qZA(),t.TgZ(11,"th"),t._uU(12,"Purpose"),t.qZA(),t.TgZ(13,"th"),t._uU(14,"TestNet URL (used to query balance)"),t.qZA(),t.TgZ(15,"th"),t._uU(16,"Comments"),t.qZA(),t.qZA(),t.qZA(),t.TgZ(17,"tbody"),t.YNc(18,v,13,6,"tr",6),t.qZA(),t.qZA(),t.qZA(),t.qZA()),2&e){const n=a.$implicit;t.xp6(1),t.Q6J("nzTitle",n.currencyType)("nzBordered",!1),t.xp6(1),t.Q6J("nzData",n.data)("nzFrontPagination",!1),t.xp6(16),t.Q6J("ngForOf",n.data)}}let g=(()=>{class e{constructor(n){this.testDataService=n,this.isLoading=!1,this.listData=[]}ngOnInit(){this.getList()}getList(n={}){this.isLoading=!0,this.listSubscription=this.testDataService.list(n).pipe((0,Z.x)(()=>this.isLoading=!1)).subscribe(i=>{0===i.code&&(this.listData=i.data)})}ngOnDestroy(){var n;null===(n=this.listSubscription)||void 0===n||n.unsubscribe()}}return e.\u0275fac=function(n){return new(n||e)(t.Y36(h))},e.\u0275cmp=t.Xpm({type:e,selectors:[["app-list"]],decls:16,vars:1,consts:[[1,"ctx-titles"],[1,"font-semibold"],[1,"inner-content","mb-20"],[1,"test-tool","md:text-sm","xl:text-sm","nzXXl:text-base"],[1,"text-red-500"],[1,"mt-8"],[4,"ngFor","ngForOf"],[3,"nzTitle","nzExtra","nzBordered"],[3,"nzData","nzFrontPagination"]],template:function(n,i){1&n&&(t.TgZ(0,"div"),t.TgZ(1,"div",0),t.TgZ(2,"nz-breadcrumb"),t.TgZ(3,"nz-breadcrumb-item",1),t._uU(4,"Test Data"),t.qZA(),t.qZA(),t.qZA(),t.TgZ(5,"div",2),t.TgZ(6,"div"),t.TgZ(7,"h3",3),t._uU(8," These data are test data prepared for users, who can use them to simulate the execution of transactions. "),t.qZA(),t._UZ(9,"br"),t.TgZ(10,"h3",3),t._uU(11," Private keys shown in this table are for sandbox demo use only. "),t.TgZ(12,"span",4),t._uU(13,"In production, private keys should be guarded and authenticated by users and/or Business Node operators as applicable. Business Node operators should take proper cybersecurity precautions when handling clients\u2019 private keys and validate that only authorized persons can sign transactions."),t.qZA(),t.qZA(),t.qZA(),t.TgZ(14,"div",5),t.YNc(15,A,19,5,"div",6),t.qZA(),t.qZA(),t.qZA()),2&n&&(t.xp6(15),t.Q6J("ngForOf",i.listData))},directives:[l.Dg,l.MO,d.sg,f.bd,o.N8,o.Om,o.$Z,o.Uo,o._C,o.p0],styles:[".inner-content[_ngcontent-%COMP%]{padding:24px;background:#fff;height:100%}.test-title[_ngcontent-%COMP%]{display:flex;justify-content:space-between;align-items:center}.test-title[_ngcontent-%COMP%]   img[_ngcontent-%COMP%]{margin-left:10px}.test-tool[_ngcontent-%COMP%]{margin-left:24px;color:#3c5686}"]}),e})();const y=[{path:"",redirectTo:"list",pathMatch:"full"},{path:"list",component:g}];let q=(()=>{class e{}return e.more=[e,g],e.\u0275fac=function(n){return new(n||e)},e.\u0275mod=t.oAB({type:e}),e.\u0275inj=t.cJS({imports:[[c.Bz.forChild(y)],c.Bz]}),e})(),x=(()=>{class e{}return e.\u0275fac=function(n){return new(n||e)},e.\u0275mod=t.oAB({type:e}),e.\u0275inj=t.cJS({imports:[[p.m,d.ez,q,u.u5,u.UX]]}),e})()}}]);