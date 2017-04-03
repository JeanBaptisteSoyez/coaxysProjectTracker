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

        public void InsertStory()
        {

        }

        public void UpdateStory()
        {

        }

        public void DeleteStory()
        {

        }
    }
}
