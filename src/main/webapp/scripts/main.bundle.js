webpackJsonp(["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"image-container set-full-height\" style=\"background-image: url('../assets/img/paper-2.jpeg')\">\n  <!--   Creative Tim Branding   -->\n  \n\n  <!--   Big container   -->\n  <div class=\"container\">\n\n    <div class=\"row\">\n      <div class=\"col-sm-8 col-sm-offset-2\">\n        <!--      Wizard container        -->\n        <div class=\"wizard-container\">\n          <div class=\"card wizard-card\" data-color=\"green\" id=\"wizard\">\n                    \n              <!--        You can switch \" data-color=\"green\" \"  with one of the next bright colors: \"blue\", \"azure\", \"orange\", \"red\"       -->\n\n              <div class=\"wizard-header\">\n                <h3 class=\"wizard-title\">Refining your Cloud Solutions</h3>\n                <p class=\"category\">This information will help us recommed you the best Cloud Solutions.</p>\n              </div>\n              <div class=\"wizard-navigation\">\n                <div class=\"progress-with-circle\">\n                  <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"1\" aria-valuemin=\"1\" aria-valuemax=\"4\" style=\"width: 15%;\"></div>\n                </div>\n                <ul>\n                  <li *ngFor=\"let name of questionTabs\">\n                    <a href=\"#{{name}}\" data-toggle=\"tab\">\n                      <div class=\"icon-circle\">\n                        <i class=\"ti-map\"></i>\n                      </div>\n                      {{name}}\n                    </a>\n                  </li>\n                </ul>\n              </div>\n              <div class=\"tab-content\">\n                <div class=\"tab-pane\" id=\"{{name}}\" *ngFor=\"let name of questionTabs\">\n                  <div class=\"row\">\n                    <div class=\"col-sm-12\" >\n                      <h5 class=\"info-text\"> Let's start with the basic details</h5>\n                    </div>\n\n                    <div class=\"col-sm-10 col-sm-offset-1\" *ngFor=\"let qs of questions[name] | entries \">\n                      <div class=\"form-group\">\n                        <label>{{qs.value.q}}</label>\n                        <div *ngIf=\"!qs.value.options\">\n                            <input type=\"{{qs.value.type}}\" min=\"{{qs.value.min}}\" max=\"{{qs.value.max}}\"/> \n                            {{opt}}\n                        </div>\n                        <div *ngIf=\"qs.value.options\">\n                            <span *ngFor=\"let opt of qs.value.options; let idx=index\">\n                                <input *ngIf=\"qs.value.type == 'radio'\"\n                                  attr.name=\"{{name + qs.key}}\"\n                                  [value] = \"idx\" \n                                  (change) = \"answers[name][qs.key] = $event.target.value\"\n                                  type=\"{{qs.value.type}}\" />\n                                \n                                <input *ngIf=\"qs.value.type == 'checkbox'\" \n                                  attr.name=\"{{name + qs.key}}\"\n                                  [value] = \"idx\" \n                                  (change) = \"updateCheckboxes(answers[name], qs.key, idx, $event.target.checked)\"\n                                  type=\"{{qs.value.type}}\" /> \n                                \n                                 {{opt}}\n                            </span>\n                        </div>\n                      </div>\n                    </div>    \n                  </div>\n                </div>\n              </div>\n              <div class=\"wizard-footer\">\n                <div class=\"pull-right\">\n                  <input type='button' class='btn btn-next btn-fill btn-success btn-wd' name='next' value='Next' />\n                  <input type='button' class='btn btn-finish btn-fill btn-success btn-wd' name='finish' value='Finish' (click)=\"submit()\" />\n                </div>\n\n                <div class=\"pull-left\">\n                  <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='Previous' />\n                </div>\n                <div class=\"clearfix\"></div>\n              </div>\n            \n          </div>\n        </div>\n        <!-- wizard container -->\n      </div>\n    </div>\n    <!-- row -->\n  </div>\n  <!--  big container -->\n\n  <div class=\"footer\">\n    <div class=\"container text-center\">\n      Made with <i class=\"fa fa-heart heart\"></i> by Cloud Brewers, Datametica.\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("./node_modules/@angular/http/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = /** @class */ (function () {
    function AppComponent(http) {
        var _this = this;
        this.http = http;
        this.title = 'app';
        this.questions = {
            storage: {
                q1: {
                    q: 'What type of data is present in your system?',
                    options: ['Structured', 'Semi Structured', 'UnStructured'],
                    type: 'radio'
                },
                q2: {
                    q: 'What type of workloads are you targeting?',
                    options: ['Batch', 'Analytical', 'Transactional', 'Database workloads'],
                    type: 'radio'
                },
                q3: {
                    q: "Is your data relational and need fully managed, high performance database service?",
                    options: ['Yes', 'No'],
                    type: 'radio'
                }
                // ,
                // test: {
                //   q: 'How do we handle numbers with constraints?',
                //   type: 'number',
                //   min: 1,
                //   max: 8
                // }
            },
            compute: {
                q1: {
                    q: 'Are you building a mobile or HTML application that does its heavy lifting, processing-wise, on the client?',
                    options: ['Yes', 'No'],
                    type: 'radio'
                },
                q2: {
                    q: 'Are you building a system based more on events than user interaction? In other words, are you building an app that responds to uploaded files, or maybe logins to other applications?',
                    options: ['Yes', 'No'],
                    type: 'radio'
                },
                q3: {
                    q: "Do you need a logical infrastructure powered by Kubernetes (the open source container orchestration system) which will help increase the velocity and improve operability by separating the app from the OS?",
                    options: ['Yes', 'No'],
                    type: 'radio'
                },
                q4: {
                    q: "Do you need a flexible, zero Ops platform for building highly available apps which will help you focus on writing code and minimize operational overhead (Platform-as-a-service (PaaS))  ?",
                    options: ['Yes', 'No'],
                    type: 'radio'
                }
            },
            network: {
                q1: {
                    q: 'Do you need private isolated virtual network partition for all resources?',
                    options: ['Yes', 'No'],
                    type: 'radio'
                },
                q2: {
                    q: 'What type of IP Address is required?',
                    options: ['Static', 'Dynamic'],
                    type: 'radio'
                },
                q3: {
                    q: "3.Does your network require firewall to control access to the instances?",
                    options: ['Yes', 'No'],
                    type: 'radio'
                },
                q4: {
                    q: "Tick which all firewall rules are required to be configured?",
                    options: ['Action: Allow or deny',
                        'Direction: Ingress or Egress',
                        'Source & Destination IPS',
                        'Protocol and port',
                        'Specific instance names',
                        'Priorities and tiebreakers'],
                    type: 'checkbox'
                }
            }
        };
        this.questionTabs = Object.keys(this.questions);
        this.answers = {};
        this.questionTabs.forEach(function (name) {
            _this.answers[name] = {};
            Object.keys(_this.questions[name]).forEach(function (q) {
                _this.answers[name][q] = null;
            });
        });
    }
    AppComponent.prototype.updateCheckboxes = function (model, key, value, checked) {
        // Init the model if not already set
        model[key] = model[key] || [];
        var array = model[key];
        var index = array.indexOf(value);
        if (checked && index < 0)
            array.push(value);
        if (!checked && index >= 0)
            array.splice(index, 1);
    };
    AppComponent.prototype.submit = function () {
        console.log('object is', this.answers);
        var parentObject = {
            "types": []
        };
        var types = parentObject.types;
        for (var key in this.answers) {
            var metricObject = {};
            metricObject["categoryType"] = key;
            metricObject["quesChoiceMap"] = {};
            for (var subKey in this.answers[key]) {
                if (this.questions[key][subKey].type == 'checkbox') {
                    var selections = this.answers[key][subKey];
                    if (!selections)
                        continue;
                    metricObject["quesChoiceMap"][subKey] = selections.join(",");
                }
                else {
                    metricObject["quesChoiceMap"][subKey] = this.answers[key][subKey];
                }
            }
            types.push(metricObject);
        }
        console.log('Object is', parentObject);
        //make http call
        this.http.post('http://localhost:8080/CRESpring4MVCAngularJS/submit/', parentObject)
            .subscribe(function (response) { return console.log('response from call', response); });
        //navigate to output route
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("./src/app/app.component.html"),
            styles: [__webpack_require__("./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Http */]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("./node_modules/@angular/platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_keys_pipe__ = __webpack_require__("./src/app/shared/keys.pipe.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_http__ = __webpack_require__("./node_modules/@angular/http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("./src/app/app.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["E" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_2__shared_keys_pipe__["a" /* KeysPipe */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_http__["b" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */]
            ],
            providers: [],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/shared/keys.pipe.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return KeysPipe; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var KeysPipe = /** @class */ (function () {
    function KeysPipe() {
    }
    KeysPipe.prototype.transform = function (value, args) {
        var keys = [];
        for (var key in value) {
            keys.push({ key: key, value: value[key] });
        }
        return keys;
    };
    KeysPipe = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["O" /* Pipe */])({ name: 'entries' })
    ], KeysPipe);
    return KeysPipe;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "./src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("./node_modules/@angular/platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("./src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("./src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_7" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("./src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map