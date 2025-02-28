<template>
  <div class="aside-hotRanking">
    <div class="aside-hotRanking-header">
      <span class="aside-hotRanking-title">
        <span>热门考研资料</span>
      </span>
      <!-- <span class="aside-hotRanking-more">
            <span>更多</span>
            <i class="el-icon-arrow-right"></i>
        </span> -->
    </div>
    <div class="aside-hotRanking-main">
      <div class="aside-hotRanking-list">
        <div
          class="aside-hotRanking-item"
          v-for="(item, index) in data"
          :key="index"
        >
          <span class="item-badge">{{ index + 1 }}</span>
          <div class="item-title">
            {{ item.title }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getHotNotes } from "@/api/notes";

export default {
  name: "hotRanking",
  data() {
    return {
      data: [],
    };
  },
  mounted() {
    this.getHotNotes();
    
    // 添加模拟的热门考研资料数据（临时方案，实际应从API获取）
    setTimeout(() => {
      this.data = [
        { id: 1, title: "2025考研政治大纲解析与复习指南" },
        { id: 2, title: "计算机专业408真题精讲与答案详解" },
        { id: 3, title: "考研英语长难句分析与翻译技巧" },
        { id: 4, title: "考研数学高频考点精讲与练习" },
        { id: 5, title: "MBA写作高分技巧与范文赏析" },
        { id: 6, title: "西综复习精要与答题模板" },
        { id: 7, title: "34所自划线院校近五年分数线汇总" }
      ];
    }, 100);
  },
  methods: {
    async getHotNotes() {
      let res = await getHotNotes();
      if (res.code === 200) {
        this.data = res.data;
      }
    },
  },
};
</script>

<style lang="less">
.aside-hotRanking {
  border-radius: 6px;
  border: 1px solid @levelThree-border-color;
  margin-bottom: 20px;

  .aside-hotRanking-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    border-bottom: 1px solid @levelOne-border-color;
    padding: 0 10px;

    .aside-hotRanking-title {
      display: flex;
      align-content: center;

      span {
        font-size: 16px;
        font-weight: 600;
        color: @main-text-color;
      }
    }

    .aside-hotRanking-more {
      display: flex;
      align-items: center;
      color: @minor-text-color;
      font-size: 14px;
      cursor: pointer;

      i {
        font-size: 14px;
      }
    }
  }

  .aside-hotRanking-main {
    .aside-hotRanking-list {
      display: flex;
      align-content: center;
      flex-wrap: wrap;

      .aside-hotRanking-item {
        display: flex;
        align-items: flex-start;
        position: relative;
        width: 100%;
        height: 67px;
        color: #212529;
        text-decoration: none;
        background-color: #fff;
        border-bottom: 1px solid rgba(0, 0, 0, 0.0625);
        padding: 12px 18px;
        transition: background-color 0.1s;
        cursor: pointer;

        &:last-child {
          border-bottom: none;
        }

        &:hover {
          color: #495057;
          text-decoration: none;
          background-color: #e3e5e7;
        }

        &:nth-child(1) .item-badge {
          background-color: #e04a1d;
        }

        &:nth-child(2) .item-badge {
          background-color: #f88217;
        }

        &:nth-child(3) .item-badge {
          background-color: #ffb916;
        }

        .item-badge {
          // min-width: 20px;
          background-color: #adb5bd;
          margin-right: 16px;
          margin-top: 4px;
          display: inline-block;
          padding: 4px 8px;
          font-size: 16px;
          font-weight: 700;
          line-height: 1;
          color: #fff;
          text-align: center;
          white-space: nowrap;
          vertical-align: baseline;
          border-radius: 4px;
        }

        .item-title {
          font-size: 16px;
          color: @main-text-color;
        }
      }
    }
  }
}
</style>