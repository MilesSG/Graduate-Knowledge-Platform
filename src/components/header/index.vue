<template>
  <div class="main-header">
    <div class="header-left-content">
      <!-- hiddenNav -->
      <div class="self-nav-toogle">
        <div class="site-nav-menu-wrapper" ref="container">
          <div
            id="site-nav-menu"
            @click="
              () => {
                isNavClick = !isNavClick;
              }
            "
          >
            <div></div>
          </div>
          <transition name="el-fade-in">
            <div
              class="dropdown-menu-container"
              style="padding-top: 15px"
              v-show="isNavClick"
            >
              <div class="nav-popover-content">
                <div class="nav-entry-popover">
                  <div class="nav-inner-list">
                    <router-link to="/index" class="nav-inner-list__item"
                      >首页
                    </router-link>
                    <router-link to="/card" class="nav-inner-list__item"
                      >考研资料
                    </router-link>
                    <router-link to="/video" class="nav-inner-list__item"
                      >考研视频
                    </router-link>
                    <router-link to="/tags/all" class="nav-inner-list__item"
                      >专业分类
                    </router-link>
                    <router-link
                      to="/message"
                      class="nav-inner-list__item entrymMessage"
                      >消息
                    </router-link>
                    <router-link
                      to="/community"
                      class="nav-inner-list__item entrymDynamic"
                      >学习社区
                    </router-link>
                    <router-link
                      to="/creator/home"
                      class="nav-inner-list__item entrymWriting"
                      >资源贡献
                    </router-link>
                  </div>
                </div>
              </div>
            </div>
          </transition>
        </div>
        <a class="self-nav-toogle-logo">
          <div class="study-logo">
            <span class="grad-cap">📚</span>
            <span class="logo-text">考研助手</span>
          </div>
        </a>
      </div>

      <!-- logo -->
      <div class="header-item-logo" @click="backHome">
        <div class="study-logo">
          <span class="grad-cap">📚</span>
          <span class="logo-text">考研知识共享平台</span>
        </div>
      </div>

      <!-- 首页 -->
      <div class="header-item-menu">
        <ul class="left-entry">
          <li class="left-entry-li">
            <router-link to="/index" active-class="le-li-active" class="nav-link"
              >首页</router-link
            >
          </li>
          <li class="left-entry-li">
            <router-link to="/card" active-class="le-li-active" class="nav-link"
              >考研资料</router-link
            >
          </li>
          <li class="left-entry-li">
            <router-link to="/video" active-class="le-li-active" class="nav-link"
              >考研视频</router-link
            >
          </li>
          <li class="left-entry-li">
            <router-link to="/tags/all" active-class="le-li-active"
              >专业分类</router-link
            >
          </li>
        </ul>
      </div>

      <!-- 搜索框 -->
      <div class="header-search">
        <el-input
          class="header-search-input"
          suffix-icon="el-icon-search"
          placeholder="搜索考研资料、专业信息..."
          @focus="focus"
          @blur="blur"
        />
        <span class="header-search-icon">
          <i class="el-icon-search"></i>
        </span>
      </div>
    </div>
    <div class="header-right-content">
      <div style="display:none">
        <!-- 已隐藏 LoginRegister 组件 -->
        <LoginRegister v-if="!isLogin" />
        <EmailResetPassword v-if="!isLogin" />
      </div>

      <!-- 消息 -->
      <div
        class="header-item badge-container"
        @mouseenter="messageMouseenter"
        @mouseleave="messageMouseleave"
      >
        <a class="right-entry-outside" @click="toMessage">
          <i class="el-icon-message"></i>
          <span class="right-entry-text">消息</span>
        </a>
        <transition name="el-fade-in">
          <div
            class="badge-popover"
            style="padding-top: 15px"
            v-show="isMessageHover"
          >
            <div class="badge-popover-content">
              <div class="message-entry-popover">
                <div class="message-inner-list">
                  <router-link
                    to="/message/comment"
                    class="message-inner-list__item"
                    >评论
                  </router-link>
                  <router-link
                    to="/message/like"
                    class="message-inner-list__item"
                    >点赞
                  </router-link>
                  <router-link
                    to="/message/follow"
                    class="message-inner-list__item"
                    >关注
                  </router-link>
                  <router-link
                    to="/message/chat"
                    class="message-inner-list__item"
                    >私信
                  </router-link>
                  <router-link
                    to="/message/system"
                    class="message-inner-list__item"
                    >系统消息
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </transition>
      </div>

      <!-- 动态 -->
      <div
        class="header-item dynamic-container"
        @mouseenter="dynamicMouseenter"
        @mouseleave="dynamicMouseleave"
      >
        <a class="right-entry-outside" @click="toDynamic">
          <i class="iconfont icon-dongtai2"></i>
          <span class="right-entry-text">社区</span>
        </a>
        <transition name="el-fade-in">
          <div
            class="dynamic-popover"
            style="padding-top: 15px"
            v-show="isDynamicHover"
          >
            <div class="dynamic-popover-content">
              <div class="dynamic-entry-popover">
                <div class="dynamic-inner-list">
                  <router-link
                    to="/community?tab=all"
                    class="dynamic-inner-list__item"
                    >全部
                  </router-link>
                  <router-link
                    to="/community/?tab=note"
                    class="dynamic-inner-list__item"
                    >笔记
                  </router-link>
                  <router-link
                    to="/community/?tab=card"
                    class="dynamic-inner-list__item"
                    >考研资料
                  </router-link>
                  <router-link
                    to="/community/?tab=video"
                    class="dynamic-inner-list__item"
                    >视频课程
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </transition>
      </div>

      <!-- 创作中心 -->
      <div class="header-item writing-container">
        <router-link to="/creator/home" class="right-entry-outside">
          <i class="iconfont icon-dengpao"></i>
          <span class="right-entry-text">资源贡献</span>
        </router-link>
      </div>

      <!-- 写笔记 -->
      <div
        class="header-item contribute-container"
        @mouseenter="uploadMouseenter"
        @mouseleave="uploadMouseleave"
      >
        <div class="options">
          <div class="releaseBtn">
            <i class="el-icon-edit"></i>
            <span>分享</span>
          </div>
        </div>
        <transition name="el-fade-in">
          <div class="contribute-popover-wrapper" v-show="isUploadHover">
            <a class="upload-item" @click="toWriteNotes">
              <i class="el-icon-edit"></i>
              <span>上传笔记</span>
            </a>
            <a @click="toWriteCard" class="upload-item">
              <i class="el-icon-postcard"></i>
              <span>上传资料</span>
            </a>
            <a @click="toWriteVideo" class="upload-item">
              <i class="el-icon-video-camera"></i>
              <span>上传视频</span>
            </a>
            <router-link
              :to="{ path: '/community' }"
              class="upload-item upload-item-dynamic"
            >
              <i class="iconfont icon-dongtai1"></i>
              <span>学习心得</span>
            </router-link>
          </div>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
// 删除 LoginRegister 和 EmailResetPassword 组件引用
import LoginRegister from "@/components/loginRegister/index";
import EmailResetPassword from "@/components/resetPassword";

import { mapState } from "vuex";
// import { _debounce, _throttle } from "@/utils/debounce.js";

export default {
  name: "Header",
  components: {
    // 保留组件以避免错误，但我们已经隐藏了它们
    LoginRegister,
    EmailResetPassword,
  },
  data() {
    return {
      // activeIndex: "1",
      avatarVisi: false,
      isAvatarHover: false,
      isMessageHover: false,
      isDynamicHover: false,
      isUploadHover: false,
      isNavClick: false,
      timer: 0, //上次打开用户头像信息框的时间，用于防抖
      delayer: null, //打开用户头像信息框延时功能
      visible: false,
      // 添加模拟用户数据
      mockUserInfo: {
        username: "考研学习者",
        avatar: "",
        id: "1",
        numFoll: 0,
        fans: 0,
        numPub: 0,
        gender: ""
      }
    };
  },
  async mounted() {
    window.addEventListener("click", this.otherClose);
    //  await this.$store.dispatch('user/getUserInfo');
  },
  beforeDestroy() {
    /* 组件销毁的时候要移除侦听器 */
    window.removeEventListener("click", this.otherClose);
  },
  methods: {
    // handleSelect(key, keyPath) {
    //   console.log(key, keyPath);
    // },
    backHome() {
      this.$router.push({
        path: "/index",
      });
    },
    //生成id
    getRands(length = 5) {
      let arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
      let rands = arr
        .sort(() => Math.random() - 0.5)
        .slice(0, length)
        .join("");
      return Number(rands);
    },
    focus() {},
    blur() {},
    otherClose(e) {
      if (!this.$refs.container.contains(e.target)) this.isNavClick = false;
    },
    loginRegister() {
      this.$store.state.global.loginRegVisible = true;
    },
    toWriteNotes() {
      if (this.isLogin) {
        let routeData = this.$router.resolve("/notes/creation");
        window.open(routeData.href, "_blank");
      } else {
        this.$message.error("请先登录！");
        this.$store.state.global.loginRegVisible = true;
      }
    },
    toWriteCard() {
      if (this.isLogin) {
        let routeData = this.$router.resolve(
          `/card/creation/${this.getRands(11)}`
        );
        window.open(routeData.href, "_blank");
      } else {
        this.$message.error("请先登录！");
        this.$store.state.global.loginRegVisible = true;
      }
    },
    toWriteVideo() {
      if (this.isLogin) {
        let routeData = this.$router.resolve("/video/creation");
        window.open(routeData.href, "_blank");
      } else {
        this.$message.error("请先登录！");
        this.$store.state.global.loginRegVisible = true;
      }
    },
    toUserCenter() {
      let routeData = this.$router.resolve(`/user/${this.userInfo.id}`);
      window.open(routeData.href, "_blank");
    },
    avatarMouseenter() {
      this.delayer = setTimeout(() => {
        const dt = Date.now();
        if (dt - this.timer > 800) {
          this.isAvatarHover = true; //大于1s调用函数
          this.timer = dt;
        }
      }, 120);
    },
    avatarMouseleave() {
      clearTimeout(this.delayer);
      this.avatarVisi = true;
      this.isAvatarHover = false;
    },
    messageMouseenter() {
      this.isMessageHover = true;
    },
    messageMouseleave() {
      this.isMessageHover = false;
    },
    dynamicMouseenter() {
      this.isDynamicHover = true;
    },
    dynamicMouseleave() {
      this.isDynamicHover = false;
    },
    uploadMouseenter() {
      this.isUploadHover = true;
    },
    uploadMouseleave() {
      this.isUploadHover = false;
    },
    userLogout() {
      this.$confirm("是否确定退出登录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          await this.$store.dispatch("user/userLogout");
        })
        .catch(() => {
          // this.$message({
          //   type: 'info',
          //   message: '已取消'
          // });
        });
    },
    toMessage() {
      this.$router.push({
        path: "/message",
      });
    },
    toDynamic() {
      this.$router.push({
        path: "/community",
      });
    },
  },
  computed: {
    // 修改计算属性，始终返回已登录状态
    isLogin() {
      return true;
    },
    userInfo() {
      return this.mockUserInfo;
    },
    message() {
      return [];
    },
    newMessage() {
      return false;
    },
    dynamciMsgNum() {
      return 0;
    }
    // ...mapState("user", [
    //   "isLogin",
    //   "userInfo",
    //   "message",
    //   "newMessage",
    //   "dynamciMsgNum",
    // ]),
  },
};
</script>

<style lang="less">
.el-header {
  width: 100%;
  padding: 0 !important;
}

.main-header {
  width: 100%;
  height: 60px;
  background: linear-gradient(to right, #f8f9fa, #ffffff);
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
}

.header-left-content {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex: 1;
  max-width: 70%;

  @media screen and (max-width: 970px) {
    .header-item-logo,
    .header-item-menu {
      display: none;
    }
    .self-nav-toogle {
      display: block;
    }
  }

  @media screen and (min-width: 970px) {
    .header-item-logo,
    .header-item-menu {
      display: block;
    }
    .self-nav-toogle {
      display: none !important;
    }
  }

  .self-nav-toogle {
    display: none;
    display: flex;
    align-items: center;
    height: 100%;
    padding: 0 16px 0 4px;
    border: none;
    font-size: 16px;
    cursor: pointer;

    .site-nav-menu-wrapper {
      height: 32px;
      width: 32px;
      justify-content: center;
      align-items: center;
      margin-right: 15px;

      #site-nav-menu {
        height: 32px;
        width: 32px;
        display: flex;
        justify-content: center;
        align-items: center;

        & > div {
          height: 2px;
          width: 20px;
          background: #585858;
          position: relative;
          border-radius: 4px;
        }

        & > div:before {
          top: -8px;
        }

        & > div:after {
          top: 7px;
        }

        & > div:after,
        & > div:before {
          content: " ";
          display: block;
          height: 2px;
          width: 20px;
          background: #585858;
          position: absolute;
          left: 0;
          border-radius: 4px;
        }
      }

      .dropdown-menu-container {
        position: absolute;
        transition: 0.3s;
        z-index: 1;
        top: 80%;

        .nav-popover-content {
          position: relative;
          background-color: #fff;
          box-shadow: 0 0 30px rgb(0 0 0 / 10%);
          border-radius: 8px;
          border: 1px solid #e3e5e7;
          color: #18191c;

          .nav-entry-popover {
            overflow: hidden;
            width: 142px;
            border-radius: 8px;

            .nav-inner-list {
              display: flex;
              flex-direction: column;
              padding: 12px 0;

              .nav-inner-list__item {
                position: relative;
                display: flex;
                align-items: center;
                padding: 10px 0 10px 27px;
                color: #61666d;
                text-align: left;
                font-size: 14px;
                transition: background-color 0.3s;

                &:hover {
                  background-color: #e3e5e7;
                }
              }

              .entrymMessage,
              .entrymDynamic,
              .entrymWriting {
                display: none;
              }

              @media screen and (max-width: 540px) {
                .entrymMessage {
                  display: block;
                }
              }
              @media screen and (max-width: 480px) {
                .entrymDynamic {
                  display: block;
                }
              }
              @media screen and (max-width: 424px) {
                .entrymWriting {
                  display: block;
                }
              }
            }
          }
        }
      }
    }

    .self-nav-toogle-logo {
      cursor: pointer;
      height: 28px;
      padding: 0 12px;
      
      .study-logo {
        display: flex;
        align-items: center;
        height: 100%;
        
        .grad-cap {
          font-size: 18px;
          margin-right: 4px;
        }
        
        .logo-text {
          font-weight: bold;
          color: #4281ff;
          font-size: 16px;
        }
      }
    }
  }

  .header-item-logo {
    cursor: pointer;
    height: 40px;
    padding: 0 12px;
    margin-right: 15px;
    flex-shrink: 0;
    
    .study-logo {
      display: flex;
      align-items: center;
      height: 100%;
      
      .grad-cap {
        font-size: 24px;
        margin-right: 8px;
      }
      
      .logo-text {
        font-weight: bold;
        color: #4281ff;
        font-size: 20px;
        letter-spacing: 1px;
        white-space: nowrap;
      }
    }
  }

  .header-item-menu {
    flex: 1;
    min-width: 0;

    .left-entry {
      display: flex;
      height: 60px;

      .left-entry-li {
        margin-right: 15px;
        height: 60px;
        display: flex;
        align-items: center;

        a {
          height: 60px;
          line-height: 60px;
          font-size: 16px;
          cursor: pointer;
          color: #18191c;
          font-weight: 500;
          transition: color 0.3s;
          position: relative;
          white-space: nowrap;
          
          &:hover {
            color: #4281ff;
          }
          
          &::after {
            content: '';
            position: absolute;
            bottom: 12px;
            left: 50%;
            width: 0;
            height: 2px;
            background-color: #4281ff;
            transform: translateX(-50%);
            transition: width 0.3s;
          }
          
          &:hover::after {
            width: 100%;
          }
        }

        .le-li-active {
          color: #4281ff;
          
          &::after {
            width: 100%;
          }
        }
      }
    }
  }

  .header-search {
    max-width: 260px;
    width: 30%;
    min-width: 180px;
    font-size: 18px;
    margin-left: auto;
    flex-shrink: 0;

    @media screen and(max-width: 720px) {
      .header-search-input {
        display: none;
      }

      .header-search-icon {
        display: block !important;
      }

      & {
        max-width: 0;
        width: 0;
        min-width: 30px;
      }
    }

    .header-search-input {
      width: 100%;

      .el-input__inner {
        border-radius: 20px;
        border: 1px solid #e0e5ef;
        padding-left: 15px;
        transition: all 0.3s;
        
        &:focus {
          border-color: #4281ff;
          box-shadow: 0 0 5px rgba(66, 129, 255, 0.3);
        }
      }
    }

    .header-search-icon {
      font-size: 18px;
      display: none;
      i {
        font-size: 18px;
        color: @general-text-color;
        font-weight: 600;
      }
    }
  }
}

.header-right-content {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  height: 60px;
  flex-shrink: 0;

  .header-search,
  .header-item,
  .header-item-login {
    padding-left: 4px;
  }

  .header-item {
    .right-entry-outside {
      position: relative;
      display: flex;
      align-items: center;
      flex-direction: column;
      flex-shrink: 0;
      margin-right: 0;
      min-width: 50px;
      text-align: center;
      font-size: 14px;
      transition: all 0.3s;
      
      &:hover {
        color: #4281ff;
        
        i, .right-entry-text {
          color: #4281ff;
        }
      }

      .badge-hint {
        position: absolute;
        right: 4px;
        top: -8px;
        width: 20px;
        height: 20px;
        border-radius: 50%;
        color: #fff;
        background-color: @danger-color;
        text-align: center;
        line-height: 20px;
        font-size: 12px;
        transform: scale(0.9);
      }
      
      i {
        font-size: 18px;
        color: #18191c;
        transition: color 0.3s;
      }
      
      .right-entry-text {
        word-break: keep-all; /* 不换行 */
        white-space: nowrap;
        color: #61666d;
        transition: color 0.3s;
      }
    }
  }

  .badge-container {
    display: flex;
    align-items: center;
    flex-direction: column;
    flex-shrink: 0;
    margin-right: 0;
    min-width: 50px;
    text-align: center;
    font-size: 13px;

    i {
      font-weight: 600;
    }

    @media screen and (max-width: 540px) {
      display: none;
    }

    .badge-popover {
      position: absolute;
      transition: 0.3s;
      z-index: 1;
      top: 80%;

      .badge-popover-content {
        position: relative;
        background-color: #fff;
        box-shadow: 0 0 30px rgb(0 0 0 / 10%);
        border-radius: 8px;
        border: 1px solid #e3e5e7;
        color: #18191c;

        .message-entry-popover {
          overflow: hidden;
          width: 122px;
          border-radius: 8px;

          .message-inner-list {
            display: flex;
            flex-direction: column;
            padding: 12px 0;

            .message-inner-list__item {
              position: relative;
              display: flex;
              align-items: center;
              padding: 10px 0 10px 27px;
              color: #61666d;
              text-align: left;
              font-size: 14px;
              transition: background-color 0.3s;

              &:hover {
                background-color: #e3e5e7;
              }

              .badge-hint {
                position: absolute;
                right: 20px;
                top: 8px;
                width: 20px;
                height: 20px;
                border-radius: 50%;
                color: #fff;
                background-color: @danger-color;
                text-align: center;
                line-height: 20px;
                font-size: 12px;
                transform: scale(0.9);
              }
            }
          }
        }
      }
    }
  }

  .dynamic-container {
    display: flex;
    align-items: center;
    flex-direction: column;
    flex-shrink: 0;
    margin-right: 0;
    min-width: 50px;
    text-align: center;
    font-size: 13px;
    .right-entry-outside {
      i {
        font-weight: 600;
        font-size: 19px;
      }
    }
    @media screen and (max-width: 448px) {
      display: none;
    }

    .dynamic-popover {
      position: absolute;
      transition: 0.3s;
      z-index: 1;
      top: 80%;

      .dynamic-popover-content {
        position: relative;
        background-color: #fff;
        box-shadow: 0 0 30px rgb(0 0 0 / 10%);
        border-radius: 8px;
        border: 1px solid #e3e5e7;
        color: #18191c;

        .dynamic-entry-popover {
          overflow: hidden;
          width: 88px;
          border-radius: 8px;

          .dynamic-inner-list {
            display: flex;
            flex-direction: column;
            padding: 12px 0;

            .dynamic-inner-list__item {
              position: relative;
              display: flex;
              align-items: center;
              padding: 10px 0 10px 27px;
              color: #61666d;
              text-align: left;
              font-size: 14px;
              transition: background-color 0.3s;

              &:hover {
                background-color: #e3e5e7;
              }
            }
          }
        }
      }
    }
  }

  .writing-container {
    margin: 0 8px 0 4px;
    @media screen and (max-width: 424px) {
      display: none;
    }
    .right-entry-outside {
      i {
        font-size: 21px;
      }
    }
  }

  .contribute-container {
    position: relative;
    padding-left: 12px;

    .options {
      font-size: 18px;

      &:hover {
        opacity: 0.9;
      }

      .releaseBtn {
        width: 90px;
        height: 36px;
        background-color: #4281ff;
        line-height: 36px;
        text-align: center;
        border-radius: 18px;
        color: #fff;
        box-shadow: 0 3px 8px rgba(66, 129, 255, 0.3);
        transition: all 0.3s;
        
        &:hover {
          transform: translateY(-2px);
          box-shadow: 0 5px 12px rgba(66, 129, 255, 0.4);
        }

        @media screen and (max-width: 360px) {
          width: 40px;

          span {
            display: none;
          }
        }

        i {
          font-size: 16px;
          margin-right: 5px;
        }

        span {
          font-size: 14px;
        }
      }
    }

    .contribute-popover-wrapper {
      position: absolute;
      top: 51px;
      right: 0;
      display: flex;
      padding: 8px 10px;
      background-color: #fff;
      box-shadow: 0 0 30px rgb(0 0 0 / 10%);
      border-radius: 8px;
      border: 1px solid #e3e5e7;

      .upload-item {
        display: flex;
        align-items: center;
        flex-direction: column;
        justify-content: center;
        width: 62px;
        height: 63px;
        border-radius: 8px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        transition: background-color 0.3s;

        &:hover {
          background-color: #e3e5e7;
        }

        i {
          color: #61666d;
          font-size: 26px;
          margin-bottom: 6px;
        }

        span {
          color: #61666d;
          font-size: 12px;
          line-height: 17px;
        }
      }

      .upload-item-dynamic {
        i {
          font-size: 29px;
        }
      }
    }
  }
}

.header-message-box {
  .ant-tabs-nav-container {
    padding: 0 16px;
  }
}

.ant-tabs-nav .ant-tabs-tab {
  margin: 0;
}

.header-theme-color-config {
  .ant-dropdown-menu {
    margin-top: -2px;
    padding: 12px;

    .color-options {
      display: flex;
      justify-content: space-around;

      div {
        width: 20px;
        height: 20px;
        margin: 0 4px;
        cursor: pointer;
        display: flex;
        align-items: center;
        justify-content: center;
      }
    }
  }
}

.avatar-menu-icon {
  font-size: 16px !important;
}

.el-menu.el-menu--horizontal {
  border: none !important;
}

.el-menu-item {
  width: none !important;
}

.contribute-popover {
  top: 51px !important;
  border-radius: 8px;
  box-shadow: 0 0 30px rgb(0 0 0 / 10%);
  border: 1px solid #e3e5e7;
  position: absolute;
}

.small-avatar {
  width: 36px;
  height: 36px;
  border-radius: 50%;
  background-color: #e3e5e7;
  display: flex;
  justify-content: center;
  align-items: center;
  
  .grad-cap {
    font-size: 22px;
    color: #4281ff;
  }
}

/* 导航栏样式优化 */
.header-container {
  display: flex;
  height: 60px;
  box-sizing: border-box;
  justify-content: space-between;
  align-items: center;
  background: linear-gradient(90deg, #fff, #f8f9fa);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
  padding: 0 20px;
  
  .header-left {
    display: flex;
    align-items: center;
  }

  .header-item-logo {
    cursor: pointer;
    margin-right: 40px;
    
    .study-logo {
      display: flex;
      align-items: center;
      
      .grad-cap {
        font-size: 24px;
        margin-right: 8px;
        transform: translateY(-2px);
      }
      
      .logo-text {
        font-size: 20px;
        font-weight: 700;
        color: #4281ff;
        letter-spacing: 0.5px;
      }
    }
  }

  .header-item-menu {
    flex: 1;
    
    .left-entry {
      display: flex;
      align-items: center;
      height: 60px;
      
      .left-entry-li {
        margin-right: 30px;
        height: 60px;
        display: flex;
        align-items: center;
        position: relative;
        
        .nav-link {
          font-size: 16px;
          font-weight: 500;
          color: #333;
          text-decoration: none;
          padding: 6px 2px;
          position: relative;
          transition: all 0.3s;
          
          &::after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            width: 0;
            height: 2px;
            background-color: #4281ff;
            transition: width 0.3s;
          }
          
          &:hover {
            color: #4281ff;
            
            &::after {
              width: 100%;
            }
          }
        }
        
        .le-li-active {
          color: #4281ff;
          font-weight: 600;
          
          &::after {
            width: 100%;
          }
        }
      }
    }
  }

  .header-right {
    display: flex;
    align-items: center;
    
    .header-search {
      margin-right: 20px;
      position: relative;
      
      .el-input__inner {
        border-radius: 20px;
        padding-left: 35px;
        background-color: #f5f7fa;
        border: 1px solid #ebeef5;
        transition: all 0.3s;
        
        &:hover, &:focus {
          background-color: #fff;
          border-color: #4281ff;
          box-shadow: 0 0 0 2px rgba(66, 129, 255, 0.1);
        }
      }
      
      .el-input__prefix {
        left: 10px;
        color: #909399;
      }
    }
    
    .header-share {
      margin-right: 20px;
      
      .share-btn {
        background-color: #4281ff;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 8px 16px;
        font-size: 14px;
        cursor: pointer;
        transition: all 0.3s;
        
        &:hover {
          background-color: #3a73e0;
          box-shadow: 0 2px 8px rgba(66, 129, 255, 0.3);
        }
        
        i {
          margin-right: 5px;
        }
      }
    }
  }
}
</style>