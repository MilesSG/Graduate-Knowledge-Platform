<template>
  <div class="aside-tag" id="tag">
    <div class="aside-tag-header">
      <span class="aside-tag-title">
        <!-- <i class=""></i> -->
        <span>{{ title || '热门考研专业' }}</span>
      </span>
      <span class="aside-tag-more" @click="toTag">
        <span>更多</span>
        <i class="el-icon-arrow-right"></i>
      </span>
    </div>
    <div class="aside-tag-main">
      <div class="aside-tag-list">
        <span class="aside-tag-item" v-for="item in hotTag" :key="item.id">{{
          item.name
        }}</span>
        <!-- <span class="aside-tag-item">语文</span>
            <span class="aside-tag-item">化学</span>
            <span class="aside-tag-item">知识</span>
            <span class="aside-tag-item">生物</span>
            <span class="aside-tag-item">常识</span>
            <span class="aside-tag-item">javaScript</span> -->
      </div>
    </div>
  </div>
</template>

<script>
import { getRandomTags } from "@/api/tag.js";
export default {
  name: "HotTag",
  props: ["title"],
  data() {
    return {
      hotTag: [],
    };
  },
  mounted() {
    this.getData();
    
    // 添加模拟的考研专业标签数据（临时方案，实际应从API获取）
    setTimeout(() => {
      this.hotTag = [
        { id: 1, name: "计算机科学" },
        { id: 2, name: "会计学" },
        { id: 3, name: "金融学" },
        { id: 4, name: "法学" },
        { id: 5, name: "管理学" },
        { id: 6, name: "医学" },
        { id: 7, name: "教育学" },
        { id: 8, name: "新闻传播" },
        { id: 9, name: "电子工程" },
        { id: 10, name: "MBA" }
      ];
    }, 100);
  },
  methods: {
    toTag() {
      this.$router.push({
        path: "/tags",
      });
    },
    async getData() {
      let result = await getRandomTags();
      if (result.code === 200) {
        this.hotTag = result.data;
      }
    },
  },
};
</script>

<style lang="less">
.aside-tag {
  height: 170px;
  border-radius: 6px;
  border: 1px solid @levelThree-border-color;
  margin-bottom: 20px;
  background-color: #fff;

  .aside-tag-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    border-bottom: 1px solid @levelOne-border-color;
    padding: 0 10px;

    .aside-tag-title {
      display: flex;
      align-content: center;

      span {
        font-size: 16px;
        font-weight: 600;
        color: @main-text-color;
      }
    }

    .aside-tag-more {
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

  .aside-tag-main {
    padding: 10px 18px;

    .aside-tag-list {
      display: flex;
      align-content: center;
      flex-wrap: wrap;

      .aside-tag-item {
        padding: 4px 8px;
        background-color: rgba(66, 129, 255, 0.1);
        color: @primary-color;
        border-radius: 4px;
        font-size: 16px;
        margin: 4px;
        cursor: pointer;
      }
    }
  }
}
</style>