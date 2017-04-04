using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Models;

namespace CoaxysProjectTracker.Repositories
{
    public class StoryRepository
    {
        public async Task<List<Story>> GetStories()
        {
            List<Story> stories = await Api.GetAsync<List<Story>>("story.json");
            return stories;
        }

        public async Task<Story> GetStoryByID(int id)
        {
            Story story = await Api.GetAsync<Story>("story1.json");
            return story;
        }

        public async Task<Story> InsertStory(Story story)
        {
            Story newStory = await Api.GetAsync<Story>("story1.json");
            return newStory;
        }

        public async Task<Story> UpdateStory(Story story)
        {
            Story updatedStory = await Api.GetAsync<Story>("story1.json");
            return updatedStory;
        }

        public async Task<Story> DeleteStory(Story story)
        {
            Story deletedStory = await Api.GetAsync<Story>("story1.json");
            return deletedStory;
        }
    }
}
