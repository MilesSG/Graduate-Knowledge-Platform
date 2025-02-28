<template>
  <el-container style="background-color: #f8f9fa">
    <el-header>
      <Header />
    </el-header>
    <el-main class="index-elMain">
      <!-- 添加考研倒计时 -->
      <div class="exam-countdown">
        <div class="countdown-content">
          <div class="countdown-title">
            <i class="el-icon-time"></i>
            <span>2025年全国硕士研究生招生考试</span>
          </div>
          <div class="countdown-timer">
            <div class="timer-item">
              <span class="timer-number">{{ countdownData.days }}</span>
              <span class="timer-label">天</span>
            </div>
            <div class="timer-separator">:</div>
            <div class="timer-item">
              <span class="timer-number">{{ countdownData.hours }}</span>
              <span class="timer-label">时</span>
            </div>
            <div class="timer-separator">:</div>
            <div class="timer-item">
              <span class="timer-number">{{ countdownData.minutes }}</span>
              <span class="timer-label">分</span>
            </div>
            <div class="timer-separator">:</div>
            <div class="timer-item">
              <span class="timer-number">{{ countdownData.seconds }}</span>
              <span class="timer-label">秒</span>
            </div>
          </div>
        </div>
      </div>
      
      <el-row :gutter="40" class="recommended-container">
        <el-col :span="12" :sm="14" class="slideShow-card">
          <SlideShow />
        </el-col>
        <el-col :span="12" :sm="10" class="right-container">
          <el-row :gutter="60" class="recommend-card">
            <!-- 9 / 15 => 0 / 24 -->
            <!-- <el-col :span="9" class="card-graphic hidden-sm-and-down">
              <div class="graphic-item">
                <a class="recommend-img">
                  <img src="../../assets/img/2.jpg"/>
                </a>
                <a class="link-recommend">如何推进远程身份验证的发展?</a>
              </div>
              <div class="graphic-item">
                <a class="recommend-img">
                  <img src="../../assets/img/3.jpg"/>
                </a>
                <a class="link-recommend">如何推进远程身份验证的发展?如何推进远程身</a>
              </div>
            </el-col> -->
            <el-col :span="24" class="card-right">
              <div class="card-notice">
                <div class="notice-name">
                  <i class="el-icon-message-solid"></i>
                  <!-- <span>公告</span> -->
                </div>
                <div class="notice-content">
                  <el-carousel
                    :interval="4000"
                    height="46px"
                    direction="vertical"
                    trigger="click"
                    :autoplay="true"
                  >
                    <el-carousel-item
                      v-for="item in announcement"
                      :key="item.id"
                    >
                      <span>{{ item.title }} </span>
                    </el-carousel-item>
                  </el-carousel>
                </div>
              </div>
              <div class="card-hot">
                <div class="card-hotList-hearder">
                  <span>
                    <i class="el-icon-guide"></i>
                    <span class="hotList-title">推荐</span>
                  </span>
                  <span @click="exchangeHotList">
                    <span class="hotList-exchange">换一批</span>
                    <i class="el-icon-refresh" ref="refreshIcon"></i>
                  </span>
                </div>
                <div class="card-hotList">
                  <div class="card-hotItem">
                    <div class="card-hotItem-mainTitle">
                      考研政治高分备考攻略
                    </div>
                    <div class="card-hotItem-subtitle">
                      本文详细介绍考研政治的复习方法、重点知识点梳理以及答题技巧，帮助考生高效备考，提高政治分数。
                    </div>
                  </div>
                  <div class="card-hotItem">
                    <div class="card-hotItem-mainTitle">
                      考研数学如何从零开始复习
                    </div>
                    <div class="card-hotItem-subtitle">
                      对于数学基础薄弱的考生，本文提供了从基础开始的复习计划，包括关键公式记忆方法、典型题型分析以及提分技巧。
                    </div>
                  </div>
                  <div class="card-hotItem">
                    <div class="card-hotItem-mainTitle">
                      英语写作高分技巧与范文分析
                    </div>
                    <div class="card-hotItem-subtitle">
                      考研英语写作是拉开分数的关键环节，本文分享了写作高分技巧、常用句式和高质量范文，助力提高英语成绩。
                    </div>
                  </div>
                  <div class="card-hotItem">
                    <div class="card-hotItem-mainTitle">
                      34所自主划线院校分数线分析
                    </div>
                    <div class="card-hotItem-subtitle">
                      详细解析34所自主划线高校近五年的分数线变化趋势，帮助考生合理选择目标院校和专业。
                    </div>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </el-col>
      </el-row>

      <!-- 添加快速入口区域 -->
      <div class="quick-entry-section">
        <div class="section-title">
          <i class="el-icon-menu"></i>
          <span>快速入口</span>
        </div>
        <div class="entry-container">
          <div class="entry-item" v-for="item in quickEntries" :key="item.id" @click="goToPage(item.link)">
            <div class="entry-icon" :style="{ backgroundColor: item.bgColor }">
              <i :class="item.icon"></i>
            </div>
            <div class="entry-text">{{ item.text }}</div>
          </div>
        </div>
      </div>

      <el-row :gutter="40" class="index-container">
        <el-col :span="18" :xs="24" :sm="24" :md="18">
          <!-- <div class="fixed-wrapper">
              <div class="notes-title">
                <span class="title">笔记</span>
              </div>
              <div class="notes-nav">
                <el-tabs v-model="activeName" @tab-click="handleClick">
                  <el-tab-pane
                    v-for="(item, index) in classifyData"
                    :key="item.id"
                    :label="item.name"
                    class="testcolor"
                    :name="'' + index"
                    @click.native="changeTag()"
                  ></el-tab-pane>
                </el-tabs>
              </div>
            </div>
            <div class="tags" ref="tags">
              <button
                class="tags-item"
                v-for="item in types"
                :key="item.id"
                @click="changeType($event, item.id)"
              >
                {{ item.name }}
              </button>
              <div
                class="tags-item arrow-icon"
                @click="foldTags"
                v-if="fristRowNum"
              >
                <span>{{ tagIsFold ? "展开" : "收起" }}</span>
                <i class="el-icon-arrow-up" v-show="!tagIsFold"></i>
                <i class="el-icon-arrow-down" v-show="tagIsFold"></i>
              </div>
            </div>
            <div class="noteList">
              <NotesList :data="notesListData" />
            </div> -->
          <div class="content-section-title">
            <i class="el-icon-video-camera"></i>
            <span>精选视频</span>
            <router-link to="/video" class="view-more">查看更多 <i class="el-icon-arrow-right"></i></router-link>
          </div>
          <VideosList class="VideosList" />
          
          <div class="content-section-title">
            <i class="el-icon-document"></i>
            <span>考研资料</span>
            <router-link to="/card" class="view-more">查看更多 <i class="el-icon-arrow-right"></i></router-link>
          </div>
          <CardsList class="CardsList" />
          
          <div class="content-section-title">
            <i class="el-icon-notebook-1"></i>
            <span>学习笔记</span>
            <router-link to="/notes" class="view-more">查看更多 <i class="el-icon-arrow-right"></i></router-link>
          </div>
          <NotesList @tranDataLen="receiveLen" />
        </el-col>
        <el-col :span="6" id="rightAside" class="hidden-sm-and-down">
          <div class="aside-wrap">
            <!-- 添加用户工具箱 -->
            <div class="user-toolbox">
              <div class="toolbox-title">考研工具箱</div>
              <div class="toolbox-content">
                <div class="tool-item" v-for="tool in toolboxItems" :key="tool.id">
                  <i :class="tool.icon"></i>
                  <span>{{ tool.name }}</span>
                </div>
              </div>
            </div>
            
            <HotTag :title="'热门标签'" />
            <Boutique />
            <AuthorsList />
            <HotRanking />
            <Links :dataLength="dataLength" />
          </div>
        </el-col>
      </el-row>
      <SideToolbar />
    </el-main>
  </el-container>
</template>

<script>
import Header from "@/components/header/index";
import SlideShow from "./slideShow/index.vue";
import NotesList from "./notesList/index.vue";
import VideosList from "./videosList/index.vue";
import CardsList from "./cardsList/index.vue";
import HotTag from "@/components/right/hotTag/index";
import Boutique from "@/components/right/boutique/index";
import HotRanking from "@/components/right/hotRanking/index";
import AuthorsList from "@/components/right/authorsList/index";
import Links from "@/components/right/links/index";
import SideToolbar from "@/components/sideToolbar/index";

export default {
  name: "Index",
  components: {
    Header,
    SlideShow,
    NotesList,
    VideosList,
    CardsList,
    HotTag,
    Boutique,
    HotRanking,
    AuthorsList,
    Links,
    SideToolbar,
  },
  data() {
    return {
      dataLength: 0,
      countdownData: {
        days: 0,
        hours: 0,
        minutes: 0,
        seconds: 0
      },
      announcement: [
        {
          id: 1,
          title: "公告：2025年全国硕士研究生招生考试时间已公布，12月21日-22日",
        },
        {
          id: 2,
          title: "公告：考研知识共享平台上线，助力广大考生备战2025考研",
        },
        {
          id: 3,
          title: "公告：各院校2024年考研复试分数线已陆续公布，可在平台查询",
        },
        {
          id: 4,
          title: "公告：新增各高校招生专业目录查询和历年报录比数据分析功能",
        },
      ],
      hotArticles: [
        {
          id: 1,
          title: "考研政治高分备考攻略",
          subtitle: "本文详细介绍考研政治的复习方法、重点知识点梳理以及答题技巧，帮助考生高效备考，提高政治分数。"
        },
        {
          id: 2,
          title: "考研数学如何从零开始复习",
          subtitle: "对于数学基础薄弱的考生，本文提供了从基础开始的复习计划，包括关键公式记忆方法、典型题型分析以及提分技巧。"
        },
        {
          id: 3,
          title: "英语写作高分技巧与范文分析",
          subtitle: "考研英语写作是拉开分数的关键环节，本文分享了写作高分技巧、常用句式和高质量范文，助力提高英语成绩。"
        },
        {
          id: 4,
          title: "34所自主划线院校分数线分析",
          subtitle: "详细解析34所自主划线高校近五年的分数线变化趋势，帮助考生合理选择目标院校和专业。"
        }
      ],
      quickEntries: [
        { id: 1, text: "政治复习", icon: "el-icon-notebook-2", bgColor: "#4281ff", link: "/card" },
        { id: 2, text: "英语备考", icon: "el-icon-reading", bgColor: "#67C23A", link: "/card" },
        { id: 3, text: "数学学习", icon: "el-icon-data-line", bgColor: "#E6A23C", link: "/card" },
        { id: 4, text: "专业课", icon: "el-icon-collection", bgColor: "#F56C6C", link: "/card" },
        { id: 5, text: "院校信息", icon: "el-icon-school", bgColor: "#909399", link: "/tags/all" },
        { id: 6, text: "复试指导", icon: "el-icon-microphone", bgColor: "#9B59B6", link: "/video" }
      ],
      toolboxItems: [
        { id: 1, name: "院校分数线查询", icon: "el-icon-search" },
        { id: 2, name: "专业课大纲下载", icon: "el-icon-download" },
        { id: 3, name: "考研日程规划", icon: "el-icon-date" },
        { id: 4, name: "报录比查询", icon: "el-icon-data-analysis" },
        { id: 5, name: "学习计划制定", icon: "el-icon-edit-outline" }
      ]
    };
  },
  async mounted() {
    await this.$store.dispatch("user/getUserInfo");
    this.startCountdown();
    // 设置定时器，每秒更新倒计时
    this.timer = setInterval(this.startCountdown, 1000);
  },
  beforeDestroy() {
    // 组件销毁前清除定时器
    clearInterval(this.timer);
  },
  methods: {
    receiveLen(e) {
      this.dataLength = e;
    },
    exchangeHotList() {
      this.$refs.refreshIcon.classList.add("rotating");
      setTimeout(() => {
        this.$refs.refreshIcon.classList.remove("rotating");
      }, 1000);
    },
    startCountdown() {
      // 设置考研日期为2025年12月21日
      const examDate = new Date(2025, 11, 21);
      const now = new Date();
      
      // 计算剩余时间（毫秒）
      const diff = examDate - now;
      
      if (diff > 0) {
        // 转换为天、时、分、秒
        const days = Math.floor(diff / (1000 * 60 * 60 * 24));
        const hours = Math.floor((diff % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((diff % (1000 * 60)) / 1000);
        
        // 更新数据
        this.countdownData = {
          days: days < 10 ? '0' + days : days,
          hours: hours < 10 ? '0' + hours : hours,
          minutes: minutes < 10 ? '0' + minutes : minutes,
          seconds: seconds < 10 ? '0' + seconds : seconds
        };
      }
    },
    goToPage(link) {
      this.$router.push(link);
    }
  },
  computed: {
    types() {
      let index = Number(this.activeName);
      let types = Object.assign({}, this.classifyData[index]).types;
      return types;
    },
  },
  watch: {
    typeId(newValue) {
      // console.log(newValue);
      if (newValue) {
        this.getNotesListData(false);
      }
    },
  },
};
</script>

<style lang="less">
.index-elMain {
  width: 1300px;
  overflow: hidden !important;
  padding-top: 20px;
  background-color: #f8f9fa;

  @media screen and (max-width: 1300px) {
    width: 1200px;
  }

  @media screen and (max-width: 1200px) {
    width: 1100px;
  }

  @media screen and (max-width: 1100px) {
    width: 100%;
  }
}

.el-container.is-vertical {
  align-items: center;
}

/* 考研倒计时样式 */
.exam-countdown {
  width: 100%;
  margin-bottom: 20px;
  background: linear-gradient(135deg, #4281ff, #2c5ab8);
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(66, 129, 255, 0.2);
  overflow: hidden;
  
  .countdown-content {
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    
    .countdown-title {
      color: white;
      font-size: 20px;
      font-weight: bold;
      margin-bottom: 15px;
      display: flex;
      align-items: center;
      
      i {
        margin-right: 10px;
        font-size: 24px;
      }
    }
    
    .countdown-timer {
      display: flex;
      justify-content: center;
      align-items: center;
      
      .timer-item {
        background-color: rgba(255, 255, 255, 0.9);
        border-radius: 8px;
        padding: 10px 15px;
        margin: 0 5px;
        display: flex;
        flex-direction: column;
        align-items: center;
        min-width: 60px;
        
        .timer-number {
          font-size: 24px;
          font-weight: bold;
          color: #333;
        }
        
        .timer-label {
          font-size: 14px;
          color: #666;
          margin-top: 5px;
        }
      }
      
      .timer-separator {
        color: white;
        font-size: 28px;
        font-weight: bold;
        margin: 0 2px;
      }
    }
  }
}

/* 快速入口区域样式 */
.quick-entry-section {
  margin: 20px 0;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  padding: 20px;
  
  .section-title {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
    
    i {
      font-size: 22px;
      color: #4281ff;
      margin-right: 8px;
    }
    
    span {
      font-size: 18px;
      font-weight: bold;
      color: #333;
    }
  }
  
  .entry-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    
    .entry-item {
      width: calc(16.66% - 15px);
      background-color: #f9f9f9;
      border-radius: 8px;
      padding: 15px 10px;
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-bottom: 15px;
      cursor: pointer;
      transition: all 0.3s;
      
      &:hover {
        transform: translateY(-5px);
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08);
      }
      
      .entry-icon {
        width: 60px;
        height: 60px;
        border-radius: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 10px;
        
        i {
          font-size: 28px;
          color: white;
        }
      }
      
      .entry-text {
        font-size: 16px;
        color: #333;
        font-weight: 500;
      }
    }
  }
}

/* 内容区域标题样式 */
.content-section-title {
  display: flex;
  align-items: center;
  margin: 15px 0;
  padding-bottom: 10px;
  border-bottom: 1px solid #eee;
  
  i {
    font-size: 22px;
    color: #4281ff;
    margin-right: 8px;
  }
  
  span {
    font-size: 18px;
    font-weight: bold;
    color: #333;
    flex: 1;
  }
  
  .view-more {
    font-size: 14px;
    color: #999;
    transition: all 0.3s;
    
    &:hover {
      color: #4281ff;
    }
    
    i {
      font-size: 14px;
      color: inherit;
      margin-left: 2px;
    }
  }
}

/* 用户工具箱样式 */
.user-toolbox {
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  margin-bottom: 20px;
  overflow: hidden;
  
  .toolbox-title {
    padding: 12px 15px;
    font-size: 16px;
    font-weight: bold;
    color: #333;
    border-bottom: 1px solid #eee;
    background-color: #f9f9f9;
  }
  
  .toolbox-content {
    padding: 10px 15px;
    
    .tool-item {
      padding: 10px 0;
      display: flex;
      align-items: center;
      border-bottom: 1px dashed #eee;
      cursor: pointer;
      transition: all 0.3s;
      
      &:last-child {
        border-bottom: none;
      }
      
      &:hover {
        color: #4281ff;
      }
      
      i {
        margin-right: 10px;
        font-size: 18px;
      }
      
      span {
        font-size: 14px;
      }
    }
  }
}

.recommended-container {
  margin-bottom: 20px;
  .slideShow-card {
    @media screen and (max-width: 840px) {
      width: 100%;
    }
  }
  .right-container {
    @media screen and(max-width: 840px) {
      display: none;
    }

    .recommend-card {
      height: 346px;

      .card-graphic {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-between;
        height: 100%;

        @media screen and(max-width: 1300px) {
          display: none;
        }

        .graphic-item {
          cursor: pointer;

          &:nth-child(1) {
            margin-bottom: 3px;
          }

          .recommend-img {
            display: block;
            width: 100%;
            height: 116px;
            overflow: hidden;
            margin-bottom: 3px;
            border-radius: 4px;
          }
          .link-recommend {
            font-weight: 700;
            font-size: 16px;
            line-height: 24px;
            max-height: 48px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: inline-block;
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            word-break: break-all;
          }
        }
      }

      .card-right {
        @media screen and(max-width: 1300px) {
          width: 100% !important;
        }

        .card-notice {
          display: flex;
          align-items: center;
          height: 46px;
          margin-bottom: 20px;
          overflow: hidden;

          .notice-name {
            display: flex;
            align-items: center;
            flex: 1;
            color: #6c757d;
            // border-right: 2px solid @warning-color;
            // padding: 0 5px 0 10px;
            // margin-right:14px;

            i {
              font-size: 22px;
              color: @warning-color;
              // margin-right: 2px;

              &:hover {
                animation: wiggle-animation 1s ease 0.3s;
              }

              @keyframes wiggle-animation {
                0% {
                  transform: rotate(0deg);
                }

                20% {
                  transform: rotate(-14deg);
                }

                60% {
                  transform: rotate(14deg);
                }

                90% {
                  transform: rotate(-6deg);
                }

                100% {
                  transform: rotate(0deg);
                }
              }
            }

            span {
              font-size: 14px;
              font-weight: 600;
              color: @warning-color;
            }
          }

          .notice-content {
            flex: 10;
            width: 100%;
            height: 46px;
            line-height: 46px;
            text-align: center;
            background-color: #faecd8;
            border-radius: 4px;
            transition: all 0.25s;

            &:hover {
              background-color: #fce8ce;
            }

            .el-carousel__indicators--vertical {
              display: none;
            }

            span {
              color: @warning-color;
              cursor: pointer;
              overflow: hidden;
              text-overflow: ellipsis;
              display: -webkit-box;
              -webkit-line-clamp: 1;
              -webkit-box-orient: vertical;
              word-break: break-all;
              padding: 0 5px;
            }
          }
        }

        .card-hot {
          height: 280px;

          .card-hotList-hearder {
            display: flex;
            align-items: center;
            justify-content: space-between;
            height: 40px;
            line-height: 40px;
            border-bottom: 1px solid @levelOne-border-color;

            & > span {
              display: flex;
              align-items: center;
              justify-content: space-between;

              &:nth-child(1) {
                i {
                  margin-right: 5px;
                  color: @primary-color;
                  user-select: none;
                  transition: all 0.6s;
                  transform-style: preserve-3d;
                  font-size: 24px;

                  &:hover {
                    transform: rotateY(-180deg);
                  }
                }

                .hotList-title {
                  font-size: 16px;
                  font-weight: 600;
                  color: @main-text-color;
                }
              }

              &:nth-child(2) {
                cursor: pointer;

                .hotList-exchange {
                  color: @minor-text-color;
                  font-size: 13px;
                }

                i {
                  margin-left: 5px;
                  font-size: 16px;
                  color: @minor-text-color;
                }

                .rotating {
                  transition: all 1s;
                  transform: rotate(-360deg);
                }
              }
            }
          }

          .card-hotList {
            .card-hotItem {
              // margin-top: 16px;
              height: 60px;
              transition: all 0.25s;
              padding: 8px 5px;
              border-radius: 4px;

              &:hover {
                box-shadow: @element-boxshadow2;
              }

              .card-hotItem-mainTitle {
                color: #222226;
                font-size: 16px;
                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 1;
                -webkit-box-orient: vertical;
                word-break: break-all;
                cursor: pointer;

                // &:hover{
                //   text-decoration: underline;
                // }
              }

              .card-hotItem-subtitle {
                margin-top: 4px;
                font-size: 14px;
                color: #999;
                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 1;
                -webkit-box-orient: vertical;
                word-break: break-all;
                cursor: pointer;
              }
            }
          }
        }
      }
    }
  }
}

.index-container {
  margin: 0 auto;

  .VideosList,
  .CardsList {
    margin-bottom: 40px;
  }
}

.el-header {
  position: sticky;
  top: 0;
  left: 0;
  box-shadow: 0 1px 3px rgb(18 18 18 / 10%);
  z-index: 999;
}

.aside-wrap {
  width: 100%;
  // border: 1px solid #ccc;

  .aside-one {
    width: 100%;
    height: 400px;
    border: 1px solid #ccc;

    &:nth-child(1) {
      margin-bottom: 10px;
    }

    &:nth-child(2) {
      margin-bottom: 10px;
    }
  }
}
</style>
